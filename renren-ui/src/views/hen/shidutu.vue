<template>
    <!-- echarts容器默认宽高为0,所以需要id,在下面样式style中对对容器进行设置-->
    <el-card>
        <h2>湿度曲线</h2>
        <div ref="myChart" id="mychart"></div>
    </el-card>
</template>

<script>
// 引用 echarts
import * as echarts from 'echarts'
import baseService from "@/service/baseService";
export default {
    name: "myChart",
    data: function () {
        return {
            data: [],
            zuidi: [],
            pingjun: []
        }
    },
    mounted() {
        this.data = []
        let data1 = [5, 10, 15, 20, 25, 30, 35]
        let data2 = [5, 10, 15, 20, 25, 30, 35]
        this.getList()
        // 1.echarts的init方法
        let myEcharts = echarts.init(this.$refs.myChart)
        // 2.设置数据
        let xdata = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        baseService.get("/demo/humidity/getList").then((res) => {
            console.log(res)
            this.data = res.data.zuida
            this.zuidi = res.data.zuidi
            this.pingjun = res.data.pingjun
            console.log(this.data)

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
                    data: ["周一", "周二", "周三", "周四", "周五", "周六", "周日"],
                },
                yAxis: {
                    type: 'value',
                    axisLabel: {
                        formatter: '{value} °C'
                    }
                },
                series: [
                    {
                        name: '最大湿度',
                        type: 'line',
                        data:this.data,
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
                    {
                        name: '平均湿度',
                        type: 'line',
                        data:this.pingjun,
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
                    {
                        name: '最低湿度',
                        type: 'line',
                        data:  this.zuidi,
                        markPoint: {
                            data: [{ name: '周最低', value: -2, xAxis: 1, yAxis: -1.5 }]
                        },
                        markLine: {
                            data: [
                                { type: 'average', name: 'Avg' },
                                [
                                    {
                                        symbol: 'none',
                                        x: '90%',
                                        yAxis: 'max'
                                    },
                                    {
                                        symbol: 'circle',
                                        label: {
                                            position: 'start',
                                            formatter: 'Max'
                                        },
                                        type: 'max',
                                        name: '最高点'
                                    }
                                ]
                            ]
                        }
                    }
                ]
            };
            // 4.设置配置项
            myEcharts.setOption(option)
        });
    },
    created() {

    },
    methods: {
        async getList() {
            baseService.get("/demo/humidity/getList").then((res) => {
                console.log(res)
                this.data = res.data
                console.log(this.data)
                // optionType=res.data
            });
        }
    }
}

const getHenList = () => {
    baseService.get("/demo/henhouse/getList").then((res) => {
        console.log(res)
        Object.assign(optionType, res.data);
        // optionType=res.data
    });
};
</script>

<style>
#mychart {
    width: 1600px;
    height: 700px;
    /* border: 1px solid red; */
}
</style>
