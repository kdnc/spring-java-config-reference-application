<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>WebSocket</title>
    <script src="/spring-code-snippets/resources/js/sockjs-0.3.4.js"></script>
    <script src="/spring-code-snippets/resources/js/stomp.js"></script>
    <script type="text/javascript">

        var stompClient = null;

        function setConnected(connected){
            document.getElementById('connectBtn').disabled = connected;
            document.getElementById('disconnectBtn').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected;
            document.getElementById('responseElem').innerHTML = '';
        }

        // open a connection to "/spring-code-snippets/hello"
        function connectClicked(){
            var socket = new SockJS('/spring-code-snippets/hello');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame){
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/greetings', function(greeting){
                    showGreeting(JSON.parse(greeting.body).content);
                });
            });
        }

        function showGreeting(message){
            var response = document.getElementById('responseElem');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }

        function disconnectClicked(){
            if(stompClient != null){
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }

        function sendName(){
            var name = document.getElementById('nameInput').value;
            stompClient.send("/websocket-app/hello", {}, JSON.stringify({'name': name}));
        }

    </script>
</head>
<body onload="disconnectClicked()">
  <h1>WebSocket</h1>
  <div>
      <button onclick="connectClicked();" id="connectBtn">Connect</button>
      <button onclick="disconnectClicked();" id="disconnectBtn">Disconnect</button>
  </div>
  <div id="conversationDiv">
      <label>What is your name?</label>
      <input type="text" id="nameInput" />
      <button onclick="sendName();">Send Response</button>
      <p id="responseElem"></p>
  </div>
</body>
</html>
