/*
$.fn.ECalendar=function(A){var f={offset:[0,0],type:1,skin:false,stamp:true,step:10};A=$.extend(f,A);var b=$(this),z,q,j,t,n,v,r,H,k,L,m,i,K,h,o,d,D,B,g,e,u=A.step,c,a,E,s=false,l,C,w=A.format?A.format:"yyyy-mm-dd hh:ii",F=A.format?A.format:"yyyy-mm-dd",G=["#ee3f2f","#1bbc9b","#297fb8","#985aa6","#e67f22","#2d3e50","#27ae61","#7e8c8d"];A.type=A.type=="time"?0:1;C=A.callback;if(!I()){if(A.type==0){b.attr("type","datetime-local")}else{b.attr("type","date")}if(callbackk){b.change(function(){C(b.val(),z)})}return false}A.format=A.type==0?w:F;if(A.skin===false){A.skin=Math.floor(Math.random()*G.length)}A.skin=G[A.skin]?G[A.skin]:A.skin;J();b.click(function(O){var y=b.attr("data-ec")?b.attr("data-ec"):b.val();var M=y?new Date(y.replace(/-/g,"/")):new Date();if(M=="Invalid Date"){M=new Date()}p(M);var P=b.offset().top-$(document).scrollTop();var x=$(window).height();var Q=b.offset();var N=b.position();if(x/2<P){z.css({"left":N.left+A.offset[0],"top":N.top-A.offset[1]-z.height()-1,})}else{z.css({"left":N.left+A.offset[0],"top":N.top+b.outerHeight()+A.offset[1],})}b.parent(".calendarWarp").css("zIndex",+10);z.show()});z.mousedown(function(x){x.stopPropagation()});$(document).mousedown(function(){if(z.is(":visible")){z.hide(0,function(){if(C){C(a.val(),z)}}).parent(".calendarWarp").css("zIndex",1)}});b.on("change",function(){var x=b.val()?new Date(b.val().replace(/-/g,"/")):null;if(x==null||x=="Invalid Date"){a.val("");b.val("")}else{p(x)}});v.click(function(){if(H.height()>0){H.animate({"height":0},200)}else{H.animate({"height":20},200)}});H.children("li").click(function(){var M=new Date();var x=$(this);var y=x.index();if(y===0){p(M)}if(y===1){p(new Date(M.getFullYear(),M.getMonth(),M.getDate()+7,M.getHours(),M.getMinutes()))}if(y===2){p(new Date(M.getFullYear(),M.getMonth()+1,M.getDate(),M.getHours(),M.getMinutes()))}if(y===3){p(new Date(M.getFullYear(),M.getMonth()+3,M.getDate(),M.getHours(),M.getMinutes()))}if(y===4){p(new Date(M.getFullYear()+1,M.getMonth(),M.getDate(),M.getHours(),M.getMinutes()))}H.animate({"height":0},200);if(C){C(a.val(),z)}});q.on("mousedown","li",function(M){var x=$(this);if(x.hasClass("prve")){L-=1}if(x.hasClass("next")){L+=1}m=x.text();c=$(this);if(A.type==0){x.css("overflow","visible").append('<div class="at12"><div class="pointer"></div></div>');l=x.find(".pointer");D=M.pageX;B=M.pageY;E=parseInt($(this).text());$("body").addClass("ECalendarNoneSelect");b.attr("readonly","readonly");c.attr("data-settime",(K<10?"0"+K:K)+":"+(h<10?"0"+h:h));var y=K*30;var y=y+(h/2);l.css({"transform":"rotate("+(y-90)+"deg)"})}p(new Date(k,L-1,m,K,h))});o.click(function(){var x=$(this);if(x.index()==0){L-=2}p(new Date(k,L,m,K,h));if(C){C(a.val(),z)}});$(j).mousedown(function(M){D=M.pageX;B=M.pageY;c=$(this);E=parseInt(c.children("span").text());var x='<i class="r3" data="'+(E-3)+'">'+(E-3)+"</i>"+'<i class="r2" data="'+(E-2)+'">'+(E-2)+"</i>"+'<i class="r1" data="'+(E-1)+'">'+(E-1)+"</i>";var y='<i class="a1" data="'+(E+1)+'">'+(E+1)+"</i>"+'<i class="a2" data="'+(E+2)+'">'+(E+2)+"</i>"+'<i class="a3" data="'+(E+3)+'">'+(E+3)+"</i>";c.prepend(x);c.append(y);c.children("i").each(function(){var N=parseInt($(this).attr("data"));if(N>12){$(this).text(12).hide()}if(N<1){$(this).text(1).hide()}});d.animate({opacity:0.1},600);$("body").addClass("ECalendarNoneSelect");b.attr("readonly","readonly")});$(n).mousedown(function(M){D=M.pageX;B=M.pageY;c=$(this);E=parseInt(c.children("span").text());var x='<i class="r3" data="'+(E-3)+'">'+(E-3)+"</i>"+'<i class="r2" data="'+(E-2)+'">'+(E-2)+"</i>"+'<i class="r1" data="'+(E-1)+'">'+(E-1)+"</i>";var y='<i class="a1" data="'+(E+1)+'">'+(E+1)+"</i>"+'<i class="a2" data="'+(E+2)+'">'+(E+2)+"</i>"+'<i class="a3" data="'+(E+3)+'">'+(E+3)+"</i>";c.prepend(x);c.append(y);d.animate({opacity:0.1},600);$("body").addClass("ECalendarNoneSelect");b.attr("readonly","readonly")});$(document).mousemove(function(O){if(c){e=parseInt((O.pageY-B)/10);g=parseInt((O.pageX-D)/10);if(c[0].tagName=="LI"){if(Math.abs(e)>1||Math.abs(g)>1){var S=(O.pageX-D);var x=(B-O.pageY);var T=90/Math.atan(1/0);var P=Math.atan(S/x)*T;if(x<0&&S>0){P=180+P}if(x<0&&S<=0){P=180+P}if(x>=0&&S<0){P=360+P}var Q=P/30;var N=parseInt(Q);var y=parseInt(((Q-N)*60)/u)*u;if(Math.abs(e)>5||Math.abs(g)>5){c.children("div").attr("class","at24");N+=12}else{c.children("div").attr("class","at12")}K=N;h=y;c.attr("data-settime",(N<10?"0"+N:N)+":"+(y<10?"0"+y:y));r.text((N<10?"0"+N:N)+":"+(y<10?"0"+y:y));l.css({"transform":"rotate("+(P-90)+"deg)"})}}else{var R=e;var M=E+R;if(c.hasClass("imonth")&&M>=1&&M<=12){c.children("i").each(function(){var U=parseInt($(this).attr("data"))+R;if(U>12||U<1){$(this).hide()}else{$(this).text(U).show()}});if(M==12){c.children("span").nextAll().hide()}else{if(M==1){c.children("span").prevAll().hide()}}c.children("span").text(M)}if(c.hasClass("iyear")){c.children("i").each(function(){var U=parseInt($(this).attr("data"))+R;$(this).text(U).show()});c.children("span").text(M)}}}});$(document).mouseup(function(){if(c){if(c[0].tagName=="LI"){var x=c.text();
p(new Date(k,L-1,m,K,h));c.removeAttr("data-settime").css({"overflow":"hidden"}).children("div").remove();z.hide(0,function(){if(C){C(a.val(),z)}}).parent(".calendarWarp").css("zIndex",1)}else{c.children("i").remove();var x=c.text();if(c.hasClass("imonth")){p(new Date(k,x-1,m,K,h))}if(c.hasClass("iyear")){p(new Date(x,L-1,m,K,h))}d.animate({opacity:1},600);if(C){C(a.val(),z)}}c=false;$("body").removeClass("ECalendarNoneSelect");b.removeAttr("readonly")}});function J(){s=true;var N='<div class="ECalendarBox ECalendarNoneSelect" style="display:none"><input type="hidden"/><div class="head"><div class="currentdate"><h2><span class="iyear"><span class="activ"></span></span>/<span class="imonth"><span class="activ"></span></span></h2><ul class="oper"><li>&lt;</li><li>&gt;</li></ul></div><div class="currenttime"><span class="ilasttext"></span><span class="itime itimebox"></span></div><ul class="select"><li>今天</li><li>一周后</li><li>一月后</li><li>三月后</li><li>一年后</li></ul><ul class="week"><li>一</li><li>二</li><li>三</li><li>四</li><li>五</li><li>六</li><li>日</li></ul></div><ul class="day"></ul></div></div>';z=$(N);z.css("border-color",A.skin);z.children("div.head").css({"border-color":A.skin,"background":A.skin});q=z.find("ul.day");j=z.find("span.imonth");t=z.find("span.iday");v=z.find("span.ilasttext");r=z.find("span.itimebox");n=z.find("span.iyear");H=z.find("ul.select");o=z.find("ul.oper li");d=z.find("div.currenttime,ul.week");a=z.children("input[type='hidden']");var M=b.attr("name");b.removeAttr("name");a.attr("name",M);b.after('<svg t="1493098552635" class="icon" style="position: absolute;right:'+(b.height()-20)/2+'px;top:50%;margin-top: -10px;" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1006" xmlns:xlink="http://www.w3.org/1999/xlink" width="20" height="20"><defs><style type="text/css"></style></defs><path d="M856.576 200.192v54.784h58.368V814.08H109.568V256.512h56.832v-56.32H51.2V870.4h921.6V200.192h-116.224z" fill="#666666" p-id="1007"></path><path d="M819.2 102.4h-204.288v255.488L819.2 358.4V102.4z" fill="#EF4848" p-id="1008"></path><path d="M563.712 664.064h256V716.8h-256zM563.712 512h256v51.2h-256zM461.312 200.192h102.4v56.32h-102.4zM205.312 664.064h256V716.8h-256zM205.312 512h256v51.2h-256z" fill="#666666" p-id="1009"></path><path d="M410.112 102.4H204.8v256l205.312-0.512V102.4z" fill="#EF4848" p-id="1010"></path></svg>');b.after(z);var x=b.attr("data-ec")?b.attr("data-ec"):b.val();var y=x?new Date(x.replace(/-/g,"/")):null;if(y!="Invalid Date"&&y!=null){p(y)}}function p(M){k=M.getFullYear();L=M.getMonth()+1;m=M.getDate();i=M.getDay();K=A.type?0:M.getHours();h=A.type?0:M.getMinutes();if(z.data("date")!=(k+"-"+L)){var T=new Date(k,L-1,1);T=T.getDay()?T.getDay():7;T=T===1?8:T;var P=new Date(k,L,0).getDate();var R=42;var O=new Date(k,L-1,0).getDate();var Q="";for(var N=1;N<=R;N++){if(N<T){Q+="<li class='other prve'>"+(O-(T-N)+1)+"</li>"}else{if(N>=T&&N<P+T){if((N-T+1)==m){Q+="<li class='activ' data='"+(N-T+1)+"'>"+(N-T+1)+"</li>"}else{Q+="<li data='"+(N-T+1)+"'>"+(N-T+1)+"</li>"}}else{Q+="<li class='other next'>"+(N-(P+T)+1)+"</li>"}}}q.html(Q)}z.find(".activ").removeClass("activ").removeAttr("style");q.children("li[data="+m+"]").addClass("activ").css("background",A.skin);var x=new Date();var S=new Date(k,L-1,m).getTime()-new Date(x.getFullYear(),x.getMonth(),x.getDate()).getTime();S=parseInt(S/(24*3600*1000));z.data("date",(k+"-"+L));j.children("span").text(L);n.children("span").text(k);var U="";if(S==0){U="今天"}else{U="<span class='itime'>"+Math.abs(S)+"</span> ";if(S>0){U+="天后"}else{U+="天前"}}v.html(U);if(A.type==0){r.text((K<10?"0"+K:K)+":"+(h<10?"0"+h:h))}var y=A.format.replace("yyyy",k).replace("mm",L).replace("dd",m).replace("hh",K).replace("ii",h);b.attr("data-ec",M);b.val(y);stamp=y.replace(/-/g,"/");stamp=Date.parse(stamp)/1000;z.data("thistime",stamp);if(A.stamp){a.val(stamp)}else{a.val(y)}}function I(){var x=navigator.userAgent;var N=["Android","iPhone","SymbianOS","Windows Phone","iPad","iPod"];var y=true;for(var M=0;M<N.length;M++){if(x.indexOf(N[M])>0){y=false;break}}return y}};console.log("\u002f\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u000d\u000a\u0020\u002a\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u002a\u0009\u0009\u000d\u000a\u0020\u002a\u0020\u0009\u0009\u0009\u0009\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u4ee3\u7801\u5e93\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u002a\u000d\u000a\u0020\u002a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0077\u0077\u0077\u002e\u0064\u006d\u0061\u006b\u0075\u002e\u0063\u006f\u006d\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u002a\u000d\u000a\u0020\u002a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0009\u0020\u0020\u52aa\u529b\u521b\u5efa\u5b8c\u5584\u3001\u6301\u7eed\u66f4\u65b0\u63d2\u4ef6\u4ee5\u53ca\u6a21\u677f\u0009\u0009\u0009\u002a\u000d\u000a\u0020\u002a\u0020\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u0009\u002a\u000d\u000a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002a\u002f");
*/
$.fn.ECalendar = function (A) {
    var f = {
        offset: [0, 0],
        type: 1,
        skin: false,
        stamp: true,
        step: 10
    };
    A = $.extend(f, A);
    var b = $(this),
        z, q, j, t, n, v, r, H, k, L, m, i, K, h, o, d, D, B, g, e, u = A.step,
        c, a, E, s = false,
        l, C, w = A.format ? A.format : "yyyy-mm-dd hh:ii",
        F = A.format ? A.format : "yyyy-mm-dd",
        G = ["#ee3f2f", "#1bbc9b", "#297fb8", "#985aa6", "#e67f22", "#2d3e50", "#27ae61", "#7e8c8d"];
    A.type = A.type == "time" ? 0 : 1;
    C = A.callback;
    if (!I()) {
        if (A.type == 0) {
            b.attr("type", "datetime-local")
        } else {
            b.attr("type", "date")
        } if (callbackk) {
            b.change(function () {
                C(b.val(), z)
            })
        }
        return false
    }
    A.format = A.type == 0 ? w : F;
    if (A.skin === false) {
        A.skin = Math.floor(Math.random() * G.length)
    }
    A.skin = G[A.skin] ? G[A.skin] : A.skin;
    J();
    b.click(function (O) {
        var y = b.attr("data-ec") ? b.attr("data-ec") : b.val();
        var M = y ? new Date(y.replace(/-/g, "/")) : new Date();
        if (M == "Invalid Date") {
            M = new Date()
        }
        p(M);
        var P = b.offset().top - $(document).scrollTop();
        var x = $(window).height();
        var Q = b.offset();
        var N = b.position();
        if (x / 2 < P) {
            z.css({
                "left": N.left + A.offset[0],
                "top": N.top - A.offset[1] - z.height() - 1,
            })
        } else {
            z.css({
                "left": N.left + A.offset[0],
                "top": N.top + b.outerHeight() + A.offset[1],
            })
        }
        b.parent(".calendarWarp").css("zIndex", +10);
        z.show()
    });
    z.mousedown(function (x) {
        x.stopPropagation()
    });
    $(document).mousedown(function () {
        if (z.is(":visible")) {
            z.hide(0, function () {
                if (C) {
                    C(a.val(), z)
                }
            }).parent(".calendarWarp").css("zIndex", 1)
        }
    });
    b.on("change", function () {
        var x = b.val() ? new Date(b.val().replace(/-/g, "/")) : null;
        if (x == null || x == "Invalid Date") {
            a.val("");
            b.val("")
        } else {
            p(x)
        }
    });
    v.click(function () {
        if (H.height() > 0) {
            H.animate({
                "height": 0
            }, 200)
        } else {
            H.animate({
                "height": 20
            }, 200)
        }
    });
    H.children("li").click(function () {
        var M = new Date();
        var x = $(this);
        var y = x.index();
        if (y === 0) {
            p(M)
        }
        if (y === 1) {
            p(new Date(M.getFullYear(), M.getMonth(), M.getDate() + 7, M.getHours(), M.getMinutes()))
        }
        if (y === 2) {
            p(new Date(M.getFullYear(), M.getMonth() + 1, M.getDate(), M.getHours(), M.getMinutes()))
        }
        if (y === 3) {
            p(new Date(M.getFullYear(), M.getMonth() + 3, M.getDate(), M.getHours(), M.getMinutes()))
        }
        if (y === 4) {
            p(new Date(M.getFullYear() + 1, M.getMonth(), M.getDate(), M.getHours(), M.getMinutes()))
        }
        H.animate({
            "height": 0
        }, 200);
        if (C) {
            C(a.val(), z)
        }
    });
    q.on("mousedown", "li", function (M) {
        var x = $(this);
        if (x.hasClass("prve")) {
            L -= 1
        }
        if (x.hasClass("next")) {
            L += 1
        }
        m = x.text();
        c = $(this);
        if (A.type == 0) {
            x.css("overflow", "visible").append('<div class="at12"><div class="pointer"></div></div>');
            l = x.find(".pointer");
            D = M.pageX;
            B = M.pageY;
            E = parseInt($(this).text());
            $("body").addClass("ECalendarNoneSelect");
            b.attr("readonly", "readonly");
            c.attr("data-settime", (K < 10 ? "0" + K : K) + ":" + (h < 10 ? "0" + h : h));
            var y = K * 30;
            var y = y + (h / 2);
            l.css({
                "transform": "rotate(" + (y - 90) + "deg)"
            })
        }
        p(new Date(k, L - 1, m, K, h))
    });
    o.click(function () {
        var x = $(this);
        if (x.index() == 0) {
            L -= 2
        }
        p(new Date(k, L, m, K, h));
        if (C) {
            C(a.val(), z)
        }
    });
    $(j).mousedown(function (M) {
        D = M.pageX;
        B = M.pageY;
        c = $(this);
        E = parseInt(c.children("span").text());
        var x = '<i class="r3" data="' + (E - 3) + '">' + (E - 3) + "</i>" + '<i class="r2" data="' + (E - 2) + '">' + (E - 2) + "</i>" + '<i class="r1" data="' + (E - 1) + '">' + (E - 1) + "</i>";
        var y = '<i class="a1" data="' + (E + 1) + '">' + (E + 1) + "</i>" + '<i class="a2" data="' + (E + 2) + '">' + (E + 2) + "</i>" + '<i class="a3" data="' + (E + 3) + '">' + (E + 3) + "</i>";
        c.prepend(x);
        c.append(y);
        c.children("i").each(function () {
            var N = parseInt($(this).attr("data"));
            if (N > 12) {
                $(this).text(12).hide()
            }
            if (N < 1) {
                $(this).text(1).hide()
            }
        });
        d.animate({
            opacity: 0.1
        }, 600);
        $("body").addClass("ECalendarNoneSelect");
        b.attr("readonly", "readonly")
    });
    $(n).mousedown(function (M) {
        D = M.pageX;
        B = M.pageY;
        c = $(this);
        E = parseInt(c.children("span").text());
        var x = '<i class="r3" data="' + (E - 3) + '">' + (E - 3) + "</i>" + '<i class="r2" data="' + (E - 2) + '">' + (E - 2) + "</i>" + '<i class="r1" data="' + (E - 1) + '">' + (E - 1) + "</i>";
        var y = '<i class="a1" data="' + (E + 1) + '">' + (E + 1) + "</i>" + '<i class="a2" data="' + (E + 2) + '">' + (E + 2) + "</i>" + '<i class="a3" data="' + (E + 3) + '">' + (E + 3) + "</i>";
        c.prepend(x);
        c.append(y);
        d.animate({
            opacity: 0.1
        }, 600);
        $("body").addClass("ECalendarNoneSelect");
        b.attr("readonly", "readonly")
    });
    $(document).mousemove(function (O) {
        if (c) {
            e = parseInt((O.pageY - B) / 10);
            g = parseInt((O.pageX - D) / 10);
            if (c[0].tagName == "LI") {
                if (Math.abs(e) > 1 || Math.abs(g) > 1) {
                    var S = (O.pageX - D);
                    var x = (B - O.pageY);
                    var T = 90 / Math.atan(1 / 0);
                    var P = Math.atan(S / x) * T;
                    if (x < 0 && S > 0) {
                        P = 180 + P
                    }
                    if (x < 0 && S <= 0) {
                        P = 180 + P
                    }
                    if (x >= 0 && S < 0) {
                        P = 360 + P
                    }
                    var Q = P / 30;
                    var N = parseInt(Q);
                    var y = parseInt(((Q - N) * 60) / u) * u;
                    if (Math.abs(e) > 5 || Math.abs(g) > 5) {
                        c.children("div").attr("class", "at24");
                        N += 12
                    } else {
                        c.children("div").attr("class", "at12")
                    }
                    K = N;
                    h = y;
                    c.attr("data-settime", (N < 10 ? "0" + N : N) + ":" + (y < 10 ? "0" + y : y));
                    r.text((N < 10 ? "0" + N : N) + ":" + (y < 10 ? "0" + y : y));
                    l.css({
                        "transform": "rotate(" + (P - 90) + "deg)"
                    })
                }
            } else {
                var R = e;
                var M = E + R;
                if (c.hasClass("imonth") && M >= 1 && M <= 12) {
                    c.children("i").each(function () {
                        var U = parseInt($(this).attr("data")) + R;
                        if (U > 12 || U < 1) {
                            $(this).hide()
                        } else {
                            $(this).text(U).show()
                        }
                    });
                    if (M == 12) {
                        c.children("span").nextAll().hide()
                    } else {
                        if (M == 1) {
                            c.children("span").prevAll().hide()
                        }
                    }
                    c.children("span").text(M)
                }
                if (c.hasClass("iyear")) {
                    c.children("i").each(function () {
                        var U = parseInt($(this).attr("data")) + R;
                        $(this).text(U).show()
                    });
                    c.children("span").text(M)
                }
            }
        }
    });
    $(document).mouseup(function () {
        if (c) {
            if (c[0].tagName == "LI") {
                var x = c.text();
                p(new Date(k, L - 1, m, K, h));
                c.removeAttr("data-settime").css({
                    "overflow": "hidden"
                }).children("div").remove();
                z.hide(0, function () {
                    if (C) {
                        C(a.val(), z)
                    }
                }).parent(".calendarWarp").css("zIndex", 1)
            } else {
                c.children("i").remove();
                var x = c.text();
                if (c.hasClass("imonth")) {
                    p(new Date(k, x - 1, m, K, h))
                }
                if (c.hasClass("iyear")) {
                    p(new Date(x, L - 1, m, K, h))
                }
                d.animate({
                    opacity: 1
                }, 600);
                if (C) {
                    C(a.val(), z)
                }
            }
            c = false;
            $("body").removeClass("ECalendarNoneSelect");
            b.removeAttr("readonly")
        }
    });

    function J() {
        s = true;
        var N = '<div class="ECalendarBox ECalendarNoneSelect" style="display:none"><input type="hidden"/><div class="head"><div class="currentdate"><h2><span class="iyear"><span class="activ"></span></span>/<span class="imonth"><span class="activ"></span></span></h2><ul class="oper"><li>&lt;</li><li>&gt;</li></ul></div><div class="currenttime"><span class="ilasttext"></span><span class="itime itimebox"></span></div><ul class="select"><li>今天</li><li>一周后</li><li>一月后</li><li>三月后</li><li>一年后</li></ul><ul class="week"><li>一</li><li>二</li><li>三</li><li>四</li><li>五</li><li>六</li><li>日</li></ul></div><ul class="day"></ul></div></div>';
        z = $(N);
        z.css("border-color", A.skin);
        z.children("div.head").css({
            "border-color": A.skin,
            "background": A.skin
        });
        q = z.find("ul.day");
        j = z.find("span.imonth");
        t = z.find("span.iday");
        v = z.find("span.ilasttext");
        r = z.find("span.itimebox");
        n = z.find("span.iyear");
        H = z.find("ul.select");
        o = z.find("ul.oper li");
        d = z.find("div.currenttime,ul.week");
        a = z.children("input[type='hidden']");
        var M = b.attr("name");
        b.removeAttr("name");
        a.attr("name", M);
        b.after('<svg t="1493098552635" class="icon" style="position: absolute;right:' + (b.height() - 20) / 2 + 'px;top:50%;margin-top: -10px;" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1006" xmlns:xlink="http://www.w3.org/1999/xlink" width="20" height="20"><defs><style type="text/css"></style></defs><path d="M856.576 200.192v54.784h58.368V814.08H109.568V256.512h56.832v-56.32H51.2V870.4h921.6V200.192h-116.224z" fill="#666666" p-id="1007"></path><path d="M819.2 102.4h-204.288v255.488L819.2 358.4V102.4z" fill="#EF4848" p-id="1008"></path><path d="M563.712 664.064h256V716.8h-256zM563.712 512h256v51.2h-256zM461.312 200.192h102.4v56.32h-102.4zM205.312 664.064h256V716.8h-256zM205.312 512h256v51.2h-256z" fill="#666666" p-id="1009"></path><path d="M410.112 102.4H204.8v256l205.312-0.512V102.4z" fill="#EF4848" p-id="1010"></path></svg>');
        b.after(z);
        var x = b.attr("data-ec") ? b.attr("data-ec") : b.val();
        var y = x ? new Date(x.replace(/-/g, "/")) : null;
        if (y != "Invalid Date" && y != null) {
            p(y)
        }
    }

    function p(M) {
        k = M.getFullYear();
        L = M.getMonth() + 1;
        m = M.getDate();
        i = M.getDay();
        K = A.type ? 0 : M.getHours();
        h = A.type ? 0 : M.getMinutes();
        if (z.data("date") != (k + "-" + L)) {
            var T = new Date(k, L - 1, 1);
            T = T.getDay() ? T.getDay() : 7;
            T = T === 1 ? 8 : T;
            var P = new Date(k, L, 0).getDate();
            var R = 42;
            var O = new Date(k, L - 1, 0).getDate();
            var Q = "";
            for (var N = 1; N <= R; N++) {
                if (N < T) {
                    Q += "<li class='other prve'>" + (O - (T - N) + 1) + "</li>"
                } else {
                    if (N >= T && N < P + T) {
                        if ((N - T + 1) == m) {
                            Q += "<li class='activ' data='" + (N - T + 1) + "'>" + (N - T + 1) + "</li>"
                        } else {
                            Q += "<li data='" + (N - T + 1) + "'>" + (N - T + 1) + "</li>"
                        }
                    } else {
                        Q += "<li class='other next'>" + (N - (P + T) + 1) + "</li>"
                    }
                }
            }
            q.html(Q)
        }
        z.find(".activ").removeClass("activ").removeAttr("style");
        q.children("li[data=" + m + "]").addClass("activ").css("background", A.skin);
        var x = new Date();
        var S = new Date(k, L - 1, m).getTime() - new Date(x.getFullYear(), x.getMonth(), x.getDate()).getTime();
        S = parseInt(S / (24 * 3600 * 1000));
        z.data("date", (k + "-" + L));
        j.children("span").text(L);
        n.children("span").text(k);
        var U = "";
        if (S == 0) {
            U = "今天"
        } else {
            U = "<span class='itime'>" + Math.abs(S) + "</span> ";
            if (S > 0) {
                U += "天后"
            } else {
                U += "天前"
            }
        }
        v.html(U);
        if (A.type == 0) {
            r.text((K < 10 ? "0" + K : K) + ":" + (h < 10 ? "0" + h : h))
        }
        var y = A.format.replace("yyyy", k).replace("mm", L).replace("dd", m).replace("hh", K).replace("ii", h);
        b.attr("data-ec", M);
        b.val(y);
        stamp = y.replace(/-/g, "/");
        stamp = Date.parse(stamp) / 1000;
        z.data("thistime", stamp);
        if (A.stamp) {
            a.val(stamp)
        } else {
            a.val(y)
        }
    }

    function I() {
        var x = navigator.userAgent;
        var N = ["Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod"];
        var y = true;
        for (var M = 0; M < N.length; M++) {
            if (x.indexOf(N[M]) > 0) {
                y = false;
                break
            }
        }
        return y
    }
};
