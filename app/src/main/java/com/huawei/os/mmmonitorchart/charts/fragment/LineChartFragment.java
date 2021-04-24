package com.huawei.os.mmmonitorchart.charts.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineDataSet;
import com.huawei.os.mmmonitorchart.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LineChartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LineChartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private LineChart mLineChart;
    private XAxis mXAxis;
    private YAxis mYAxisLeft;
    private Legend mLegend;

    // for testing
    private Map<Float, List<Float>> testData;
    private String[] titles = {"MemAvailable", "MemFree", "Slab", "SReclaimable", "SUnreclaim", "SwapFree"};

    public LineChartFragment() {
        // Required empty public constructor
    }

    private int setTestData(Map<Float, List<Float>> dataSet) {
        int length = 0;

        float[] x = {0, 5, 10, 15, 20, 25};
        float[][] oriData = {
                {3000, 285, 765, 471, 286, 2489},
                {2749, 285, 765, 471, 286, 2471},
                {2712, 285, 765, 471, 286, 2356},
                {2682, 285, 765, 471, 286, 2401},
                {2917, 285, 682, 396, 286, 2217},
                {2863, 285, 684, 398, 286, 2100}
        };

        return length;
    }

    private void initLineChart(LineChart chart) {
        // view initialization
        chart.setDrawGridBackground(true);              // 网格线开关
        chart.setPinchZoom(true);                       // 等比缩放

        mXAxis = mLineChart.getXAxis();
        mXAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // 设置X轴位置
        mXAxis.setAxisMinimum(0f);                      // 设置起点
        mXAxis.setGranularity(5f);                      // 设置单位间距

        mYAxisLeft = mLineChart.getAxisLeft();
        mYAxisLeft.setAxisMinimum(0f);
        mYAxisLeft.setDrawLimitLinesBehindData(true);   // 设置数据线是否超出最后一个数据点

        mLegend = mLineChart.getLegend();
        mLegend.setForm(Legend.LegendForm.LINE);        // 设置图例类型
        mLegend.setTextSize(12f);                       // 设置图例字体大小
        mLegend.setDrawInside(false);                   // 设置图例是否在图内
        mLegend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        mLegend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        mLegend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
    }

    private void initLineChartDataSet(LineDataSet lineDataSet, int color, LineDataSet.Mode mode) {
        lineDataSet.setColor(color);
        lineDataSet.setCircleColor(color);
        lineDataSet.setLineWidth(1f);                   // 设置线条粗细
        lineDataSet.setCircleRadius(3f);                // 设置数据点半径
        lineDataSet.setDrawCircleHole(false);           // 设置数据点空心/圆心
        lineDataSet.setValueTextSize(12f);              // 设置数据标签值字体大小
        lineDataSet.setDrawFilled(true);                // 设置折线图填充（连线？）
        lineDataSet.setFormLineWidth(1f);
        lineDataSet.setFormSize(15.f);

        // 设置曲线类型，默认为折线，可设置为圆滑曲线
        if (mode == null) {
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LineChartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LineChartFragment newInstance(String param1, String param2) {
        LineChartFragment fragment = new LineChartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_line_chart, container, false);
    }


}