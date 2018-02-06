var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('http://127.0.0.1:8083/discussionchat');
    console.log('socket object ' );
    stompClient = Stomp.over(socket);
    console.log('going to connect ');
    stompClient.connect({"user" : document.getElementById("sender").value}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/reply', function (greeting) {
            showGreeting(JSON.parse(greeting.body).ownerUser.email,JSON.parse(greeting.body).description,"Me");
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
	var owneruser;
	if($("#sender").val()== "disha1308@gmail.com")
		owneruser = 1;
	else
		owneruser = 2;
	//need userid which will be stored in session attribute.
    stompClient.send("/answers", {}, JSON.stringify({'description': $("#msgContent").val(), 'session':{'id':1},'ownerUser': {'id':owneruser},'ownerQuestion': {'id':1}}));
    showGreeting("Me",$("#msgContent").val(),$("#receiver").val());
        
}

function showGreeting(sender,message,receiver) {
    $("#greetings").append("<tr><td>" + sender + "</td><td>"+message+"</td><td>"+receiver+"</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});