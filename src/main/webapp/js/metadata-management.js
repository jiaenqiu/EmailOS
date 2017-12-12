/**
 * 元数据管理
 */
$(document).ready(function () {
    /* 查询元数据列表 */
    showUserList();

    $('#saveUserInfo').click(function(){
        var user_id = $('#user_id').val().trim();
        var user_name = $('#user_name').val().trim();
        var user_phone = $('#user_phone').val().trim();
        var user_id_card = $('#user_id_card').val().trim();
        var user_content = $('#user_content').val().trim();
        if(user_name == '' || user_name.length == 0){
            alert('名字不能为空!')
            $('#user_name').focus();
            return false;
        }
        if(user_name.length > 150){
            alert('名字过长!')
            $('#user_name').focus();
            return false;
        }
        saveUserInfo(user_id,user_name,user_phone,user_id_card,user_content);
    });
    function saveUserInfo(user_id,user_name,user_phone,user_id_card,user_content) {
        console.log(user_id+'------'+user_name+'----'+user_phone);
        if(user_id == '' && user_id == 0){
            addUser(user_name,user_phone,user_id_card,user_content);
        } else {
            updateUserById(user_id,user_name,user_phone,user_id_card,user_content);
        }
    }
    function addUser(user_name,user_phone,user_id_card,user_content) {
        $.ajax({
            url: 'user/register',
            type:'POST',
            data:{user_name:user_name,user_phone:user_phone,user_id_card:user_id_card,user_content:user_content},
            success:function(data){
                if(data == -1){
                    $('#resultMsg').removeClass('text-success');
                    $('#resultMsg').addClass('text-danger');
                    $('#resultMsg').html('当前数据中心已存在，请重新输入！');
                    $('#metaName').focus();
                    $('#resultMsg').removeClass('hidden');
                    $('#addDataModal').on('hidden.bs.modal',function(){
                        showUserList();
                    });
                }else if(data == 0){
                    $('#resultMsg').removeClass('text-success');
                    $('#resultMsg').addClass('text-danger');
                    $('#resultMsg').html('添加失败！');
                    $('#resultMsg').removeClass('hidden');
                    $('#addDataModal').on('hidden.bs.modal',function(){
                        showUserList();
                    });
                }else{
                    $('#resultMsg').removeClass('text-danger');
                    $('#resultMsg').addClass('text-success');
                    $('#resultMsg').html('操作成功！');
                    $('#resultMsg').removeClass('hidden');
                    showUserList();
                    $('#addDataModal').hide();
                }
            }
        });
    }

    function showUserList() {
        $.ajax({
            type: "GET",
            url: 'user/queryAllUsers',
            //dataType: 'json',
            success: function (data) {
                console.log(data);
                var usersList = '';
                if(data.flag) {
                    var users = JSON.parse(data.result);//取出后台返回结果，并转换为json
                    var num = count(users);
                    //var num = 1;
                    console.log('users.length:'+num)
                    if(num > 0){
                        for(var i=0;i<num;i++){
                            usersList += '<tr class="info">'+
                                '<td>'+users[i].user_id+'</td>'+
                                '<td>'+users[i].user_name+'</td>'+
                                '<td>'+users[i].user_phone+'</td>'+
                                '<td>'+users[i].user_id_card+'</td>'+
                                '<td>'+users[i].user_content+'</td>'+
                                '<td>'+
                                '<a href="javascript:void(0);" class="detailsUser" user_id="'+users[i].user_id+'" title="详情"><i class="glyphicon glyphicon-eye-open"></i></a>&nbsp;'+
                                '<a href="javascript:void(0);" class="editUser" user_id="'+users[i].user_id+'" title="编辑"><i class="glyphicon glyphicon-edit"></i></a>&nbsp;'+
                                '<a href="javascript:void(0);" class="delUser" user_id="'+users[i].user_id+'" title="删除"><i class="glyphicon glyphicon-remove"></i></a>&nbsp;'+
                                '</td>'+
                                '</tr>';

                                // <!--<button type="button" class="btn btn-primary btn-xs"-->
                                // <!--data-toggle="modal" data-target="#updateModal">-->
                                // <!--<i class="glyphicon glyphicon-pencil"></i>-->
                                // <!--</button>-->
                                // <!--<button type="button" class="btn btn-primary btn-xs"-->
                                // <!--data-toggle="modal" data-target="#deleteModal">-->
                                // <!--<i class="glyphicon glyphicon-remove"></i>-->
                                // <!--</button>-->
                                // <!--</td>-->
                        }
                    } else {
                        usersList = '<tr><td colspan="5" class="text-center">无数据中心，请添加。</td></tr>';
                    }
                }
                $('#usersList tbody').html(usersList);
                $('#usersList .detailsUser').click(function(){
                    var user_id = $(this).attr('user_id');
                    detailsUser(user_id);
                });
                $('#usersList .editUser').click(function(){
                    var user_id = $(this).attr('user_id');
                    editUser(user_id);
                });
                $('#usersList .delUser').click(function(){
                    var user_id = $(this).attr('user_id');
                    delUser(user_id);
                });
            }
        });
    }

    function detailsUser(user_id){
        $('#detailsModal').show();
        $.ajax({
            type: "POST",
            url: 'user/selectUserById',
            data:{user_id:user_id},
            dataType:'json',
            success:function(data){
                var user = JSON.parse(data.result);
                $('#user_id2').val(user_id);
                $('#user_name2').val(user.user_name);
                $('#user_phone2').val(user.user_phone);
                $('#user_id_card2').val(user.user_id_card);
                $('#user_content2').val(user.user_content);
                showUserList();
            },
            error:function(data){
                $('#resultDelMsg').html('查询失败！');
            }
        });
    }

    function editUser(user_id){
        if(user_id == 0){
            $('#myModalLabel').html('添加新数据');
            $('#user_id').val('');
            $('#user_name').val('');
            //$('#resultMsg').addClass('hidden');
            $('#addDataModal').show();
        }else{
            $('#myModalLabel').html('编辑数据');
            $('#user_id').val(user_id);
            //$('#resultMsg').addClass('hidden');
            $.ajax({
                type: "POST",
                url: 'user/selectUserById',
                data:{user_id:user_id},
                dataType:'json',
                success:function(data){
                    var user = JSON.parse(data.result);
                    console.log('selectUserById:'+user_id);
                    $('#user_id').val(user_id);
                    $('#user_name').val(user.user_name);
                    $('#user_phone').val(user.user_phone);
                    $('#user_id_card').val(user.user_id_card);
                    $('#user_content').val(user.user_content);
                    $('#addDataModal').show();
                }
            });
        }
    }

    function updateUserById(user_id,user_name,user_phone,user_id_card,user_content){
        $.ajax({
            url: 'user/updateUser',
            type: 'post',
            data: {user_id:user_id,user_name:user_name,user_phone:user_phone,user_id_card:user_id_card,user_content:user_content},
            success:function(data){
                if(data == -1){
                    $('#resultMsg').removeClass('text-success');
                    $('#resultMsg').addClass('text-danger');
                    $('#resultMsg').html('操作失败！');
                    $('#resultMsg').removeClass('hidden');
                }else{
                    $('#resultMsg').removeClass('text-danger');
                    $('#resultMsg').addClass('text-success');
                    $('#resultMsg').html('操作成功！');
                    $('#resultMsg').removeClass('hidden');
                }
                showUserList();
                $('#addDataModal').hide();
            }
        });
    }

    function delUser(user_id){
        $('#deleteModal').show();
        if(!confirm('确定要删除此数据吗？')){
            $('#deleteModal').hide();
            return false;
        }
        $.ajax({
            type: "POST",
            url: 'user/delUserById',
            data:{user_id:user_id},
            dataType:'json',
            success:function(data){
                showUserList();
                $('#deleteModal').hide();
            },
            error:function(data){
                $('#resultDelMsg').html('删除失败！');
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
