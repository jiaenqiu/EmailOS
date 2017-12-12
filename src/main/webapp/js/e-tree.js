$(document).ready(function () {
    var myChart = echarts.init(document.getElementById('tree'));
//	myChart.showLoading();
    $.ajax({
        type: "get", //请求方式为get，也可以是设置为post
        url: "./json/flare.json", //所要获取的json文件相对地址，注意不要写错了，我这里放在同一个目录下的
        async: true, //是否为异步请求，ture为异步请求，false为同步请求
        success: function (data) { //当请求之后调用。传入返回后的数据，以及包含成功代码的字符串
//        		myChart.hideLoading();
            echarts.util.each(data.children, function (datum, index) {
                index % 2 === 0 && (datum.collapsed = true);
            });
            alert('myChart' + myChart);
            window.setTimeout(function () {
                alert('data' + data);
            }, 2000);
            var option = {
                tooltip: {trigger: 'item', triggerOn: 'mousemove'},
                series: [
                    {
                        type: 'tree', data: [data], top: '1%', left: '5%', bottom: '1%', right: '3%', symbolSize: 7,
                        label: {
                            normal: {
                                position: 'left', verticalAlign: 'middle', align: 'right', fontSize: 9
                            }
                        },
                        leaves: {
                            label: {
                                normal: {
                                    position: 'right', verticalAlign: 'middle', align: 'left'
                                }
                            }
                        },
                        expandAndCollapse: true, animationDuration: 550, animationDurationUpdate: 750
                    }
                ]
            };
            if (option && typeof option === "object") {
                myChart.setOption(option, true);
            }
        }
    });
});