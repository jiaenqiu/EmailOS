$(document).ready(function () {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('histogram'));
    // 指定图表的配置项和数据
    var option = {
        title: {text: '本周邮件'},
        tooltip: {},
        legend: {
            data: ['封数']
        },
        xAxis: {
            data: ["周一", "周二", "周三", "周四", "周五", "周末"]
        },
        yAxis: {},
        series: [{
            name: '封数',
            type: 'bar',
            data: [10, 5, 2, 15, 6, 1]
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
});