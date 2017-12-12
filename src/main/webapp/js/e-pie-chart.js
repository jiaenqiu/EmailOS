$(document).ready(function () {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('pie'));
    var option = {
        title: {
            text: '邮件分类',
            subtext: '私密',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['省邮件', '市邮件', '县邮件', '广告邮件', '其他']
        },
        series: [
            {
                name: '邮件源',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: 335, name: '省邮件'},
                    {value: 310, name: '市邮件'},
                    {value: 234, name: '县邮件'},
                    {value: 135, name: '广告邮件'},
                    {value: 1548, name: '其他'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
});