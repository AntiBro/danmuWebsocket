var ws = new WebSocket("ws://127.0.0.1:8004/Server/wsserver");
function guid() {
    function S4() {
        return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+S4()+S4()+S4()+S4()+S4()+S4());
}
function SendMsg(e,type){
// douyu TV
    if(type==0){
        if($(e.target).find(".chat-msg-item").length>0){
            var json = {};
            json.id = guid();
            json.website =window.location.host;
            var spanname=$(e.target).find(".name>a").text();
            spanname=spanname.replace("：","");
            json.userid = spanname;
            json.username=spanname;
            json.content=$(e.target).find(".chat-msg-item").text();
            var url = window.location.href;
            json.romeid=url.split("/")[url.split("/").length-1];
            json.rometype="0";
            json.romeurl=url;
            //console.log(JSON.stringify(json));
            if (ws.readyState == ws.OPEN)
                ws.send(JSON.stringify(json));
            else
                ws = new WebSocket(ws);

        }
    }
//panda TV
    if(type==1){
        if($(e.target).find(".room-chat-content").length>0){
            var json = {};
            json.id = guid();
            json.website =window.location.host;
            var spanname=$(e.target).find(".name").text();
            spanname=spanname.replace(":","");
            json.userid = spanname;
            json.username=spanname;
            json.content=$(e.target).find(".room-chat-content").text();
            var url = window.location.href;
            json.romeid=url.split("/")[url.split("/").length-1];
            json.rometype="0";
            json.romeurl=url;
            //console.log(JSON.stringify(json));
            if (ws.readyState == ws.OPEN)
                ws.send(JSON.stringify(json));
            else
                ws = new WebSocket(ws);

        }

    }

    if(type==2){

        if($(e.target).find(".chat-span").length>0){
            var json = {};
            json.id = guid();
            json.website =window.location.host;
            var spanname=$(e.target).find(".di").text();
            spanname=spanname.replace(":","");
            json.userid = spanname;
            json.username=spanname;
            json.content=$(e.target).find(".chat-span").text();
            var url = window.location.href;
            json.romeid=url.split("/")[url.split("/").length-1];
            json.rometype="0";
            json.romeurl=url;
            console.log(JSON.stringify(json));
            if (ws.readyState == ws.OPEN)
                ws.send(JSON.stringify(json));
            else
                ws = new WebSocket(ws);

        }


    }
}

ws.onopen = function() {};
ws.onclose = function() {};
window.close = function(){ws.onclose();};

window.onbeforeunload = function() {
    if (ws.readyState == ws.OPEN) {
        ws.close();
    }
}
/**
 * Bind Event
 */
/*douyu TV*/
$("#js-chat-cont .c-list").bind('DOMNodeInserted', function(e) {
    SendMsg(e,0)
});
/*panda TV*/
$(".room-chat-messages").bind('DOMNodeInserted', function(e) {
    SendMsg(e,1)
});
/*zhanqi TV*/
$(".js-chat-msg-list").bind('DOMNodeInserted', function(e) {
    SendMsg(e,2)
});
/**
 * quanming TV
 */

