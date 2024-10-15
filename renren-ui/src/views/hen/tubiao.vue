<template>
    <!-- echarts容器默认宽高为0,所以需要id,在下面样式style中对对容器进行设置-->
    <el-card>
        <h2>温度曲线</h2>
        <div ref="myChart" id="mychart"></div>
    </el-card>
</template>

<script>
// 引用 echarts
import * as echarts from 'echarts'
import baseService from "@/service/baseService";
export default {
    name: "myChart",
    mounted() {
        // 1.echarts的init方法
        let myEcharts = echarts.init(this.$refs.myChart)
        // 2.设置数据
        let xdata = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        let data = [ 5, 10, 15, 20, 25, 30,35]
        baseService.get("/demo/thermal/getList").then((res) => {
            console.log(res)
            let wendu = res.data.wendu
            let time = res.data.time
         
            let option = {
                // title: {
                //     text: 'Temperature Change in the Coming Week'
                // },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {},
                toolbox: {
                    show: true,
                    feature: {
                        dataZoom: {
                            yAxisIndex: 'none'
                        },
                        dataView: { readOnly: false },
                        magicType: { type: ['line', 'bar'] },
                        restore: {},
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: time,
                },
                yAxis: {
                    type: 'value',
                    axisLabel: {
                        formatter: '{value} °C'
                    }
                },
                series: [
                    {
                        name: '温度',
                        type: 'line',
                        data:wendu,
                        markPoint: {
                            data: [
                                { type: 'max', name: 'Max' },
                                { type: 'min', name: 'Min' }
                            ]
                        },
                        markLine: {
                            data: [{ type: 'average', name: 'Avg' }]
                        }
                    },
                    // {
                    //     name: '平均湿度',
                    //     type: 'line',
                    //     data:this.pingjun,
                    //     markPoint: {
                    //         data: [
                    //             { type: 'max', name: 'Max' },
                    //             { type: 'min', name: 'Min' }
                    //         ]
                    //     },
                    //     markLine: {
                    //         data: [{ type: 'average', name: 'Avg' }]
                    //     }
                    // }
                ]
            };
            // 4.设置配置项
            myEcharts.setOption(option)
        });
        // let option = {
        //     xAxis: {
        //         type: "category",
        //         data: ["周一", "周二", "周三", "周四", "周五", "周六", "周日"],
        //     },
        //     yAxis: {
        //         name: "单位：°C",
        //         type: "value",
        //     },
        //     series: [
        //         {
        //             smooth: true,//平滑曲线
        //             data: [150, 230, 224, 218, 135, 147, 260],
        //             type: "line",
        //         },
        //         {
        //             name: 'Union Ads',
        //             type: 'line',
        //             stack: 'Total',
        //             data: [220, 182, 191, 234, 290, 330, 310]
        //         },
        //         {
        //             name: 'Direct',
        //             type: 'line',
        //             stack: 'Total',
        //             data: [320, 332, 301, 334, 390, 330, 320]
        //         },
        //     ],
        // };

        // // 4.设置配置项
        // myEcharts.setOption(option)
    }
}
</script>

<style>
#mychart {
    width: 1600px;
    height: 700px;
    /* border: 1px solid red; */
}
</style>
