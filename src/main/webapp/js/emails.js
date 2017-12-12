/**
 * 邮件
 */
$(document).ready(function () {
    /* 查询元数据列表 */
    showEmailsList();


    function showEmailsList() {
        var emailsList = '';
        $.ajax({
            type: "GET",
            url: 'email/queryAllEmails',
            success: function (data) {
                console.log(data);
                var emails = JSON.parse(data.result);
                var num = count(emails);
                console.log('emails.length:'+num);
                if(num > 0){
                    for(var i=0;i<num;i++){
                        emailsList += '<tr class="info">'+
                            '<td>'+emails[i].email_id+'</td>'+
                            '<td>'+emails[i].email_rank+'</td>'+
                            '<td>'+emails[i].email_name+'</td>'+
                            '<td>'+emails[i].email_phone+'</td>'+
                            '<td>'+emails[i].email_str+'</td>'+
                            '<td>'+
                            '<a href="javascript:void(0);" class="sendEmail" email_id="'+emails[i].email_id+'" id="emailJob" title="详情"><i class="glyphicon glyphicon-envelope"></i></a>&nbsp;'+
                            '<a href="javascript:void(0);" class="editEmail" email_id="'+emails[i].email_id+'" title="编辑"><i class="glyphicon glyphicon-edit"></i></a>&nbsp;'+
                            '<a href="javascript:void(0);" class="delEmail" email_id="'+emails[i].email_id+'" title="删除"><i class="glyphicon glyphicon-remove"></i></a>&nbsp;'+
                            '</td>'+
                            '</tr>';
                    }
                } else {
                    emailsList += '<tr><td colspan="5" class="text-center">无email数据，请添加。</td></tr>';
                }
                $('#emailsList tbody').html(emailsList);
                $('#emailsList .sendEmail').click(function(){
                    var email_id = $(this).attr('email_id');
                    sendEmail(email_id);
                });
                $('#emailsList .editEmail').click(function(){
                    var email_id = $(this).attr('email_id');
                    //editEmail(email_id);
                });
                $('#emailsList .delEmail').click(function(){
                    var email_id = $(this).attr('email_id');
                    //delEmail(email_id);
                });
            }
        });
    }

    function sendEmail(email_id) {
        $.ajax({
            type: "POST",
            url: 'email/sendEmail',
            data:{email_id:email_id},
            dataType:'json',
            success:function(data){
                if(data.flag) {
                    //alert('send email is ok');
                    window.setTimeout(function() {
                        $("#myAlert").css('display','block');
                    },500);
                    window.setTimeout(function() {
                        $("#myAlert").css('display','none');
                    },3000);
                }
            }
        });
    }


    function count(json){
        var jsonLength = 0;
        for (var i in json) {
            jsonLength++;
        }
        return jsonLength;
    }
});