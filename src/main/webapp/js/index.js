$(document).ready(function () {

    $("#rightShow").load("others.html #page", null, function () {
//		alert("加载成功");
    });
    $("#tree").treeview();
    $("#home").bind("click", function () {
        $("#rightShow").load("others.html #page", null, function () {
        });
    });

    $("#dataManagement").bind("click", function () {
        dataManagementPublic();
    });
    $("#dataManagement2").bind("click", function () {
        dataManagementPublic();
    });

    function dataManagementPublic() {
        $("#page").show();
        $('#rightShow').load("MetaDataManagement.html");
    }

    $("#notice").bind("click", function () {
        noticePublic();
    });
    $("#notice2").bind("click", function () {
        noticePublic();
    });
    $("#notice3").bind("click", function () {
        noticePublic();
    });
    $("#notice4").bind("click", function () {
        noticePublic();
    });

    function noticePublic() {
        $("#page").show();
        $("#rightShow").load("emails.html");
    }

    $("#analysis").bind("click", function () {
        $("#page").hide();
        $("#rightShow").load("analysis.html");
    });
    $("#analysis2").bind("click", function () {
        $("#page").hide();
        $("#rightShow").load("analysis.html");
    });
    $("#contact").bind("click", function () {
        $("#page").hide();
        $("#rightShow").load("contact.html");
    });
    $("#contact2").bind("click", function () {
        $("#page").hide();
        $("#rightShow").load("contact.html");
    });

//	$('#addDataModal').on('shown.bs.modal', function () {
////		alert('23413');
//	});

    $('#pageLimit').bootstrapPaginator({
        currentPage: 1,//当前的请求页面。
        totalPages: 10,//一共多少页。
        size: "normal",//应该是页眉的大小。
        bootstrapMajorVersion: 3,//bootstrap的版本要求。
        alignment: "right",
        numberOfPages: 3,//一页列出多少数据。
        itemTexts: function (type, page, current) {//如下的代码是将页眉显示的中文显示我们自定义的中文。
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一页";
                case "next":
                    return "下一页";
                case "last":
                    return "末页";
                case "page":
                    return page;
            }
        }
    });

    AddFavorite = function (sURL, sTitle) {
        try {
            window.external.addFavorite(sURL, sTitle);
        } catch (e) {
            try {
                window.sidebar.addPanel(sTitle, sURL, "");
            } catch (e) {
                alert("加入收藏失败，请使用ctrl/command+D进行添加");
            }
        }
    }
    SetHome = function (obj, url) {
        try {
            obj.style.behavior = 'url(#default#homepage)';
            obj.setHomePage(url);
        } catch (e) {
            if (window.netscape) {
                try {
                    netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                } catch (e) {
                    alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将[signed.applets.codebase_principal_support]设置为'true'");
                }
                var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
                prefs.setCharPref('browser.startup.homepage', url);
            }
        }
    }


    // custom uiDropdown element, example can be seen in user-list.html on the 'Filter users' button
    var uiDropdown = new function () {
        var self;
        self = this;
        this.hideDialog = function ($el) {
            return $el.find(".dialog").hide().removeClass("is-visible");
        };
        this.showDialog = function ($el) {
            return $el.find(".dialog").show().addClass("is-visible");
        };
        return this.initialize = function () {
            $("html").click(function () {
                $(".ui-dropdown .head").removeClass("active");
                return self.hideDialog($(".ui-dropdown"));
            });
            $(".ui-dropdown .body").click(function (e) {
                return e.stopPropagation();
            });
            return $(".ui-dropdown").each(function (index, el) {
                return $(el).click(function (e) {
                    e.stopPropagation();
                    $(el).find(".head").toggleClass("active");
                    if ($(el).find(".head").hasClass("active")) {
                        return self.showDialog($(el));
                    } else {
                        return self.hideDialog($(el));
                    }
                });
            });
        };
    };
    // instantiate new uiDropdown from above to build the plugins
    new uiDropdown();


});

