<%-- 
    Document   : DoorLockPage.jsp
    Created on : Oct 20, 2018, 6:34:33 PM
    Author     : cgallen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.model.CardKey"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.model.HotelReceptionService"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.model.SecretKeyProvider"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.model.HotelRoomLockService"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.roomlock.HotelRoomLockServiceImpl"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.secretkey.SecretKeyProviderImpl"%>
<%@page import="solent.ac.uk.ood.examples.hotellock.reception.HotelReceptionServiceImpl"%>
<%
String roomNumber = (String) request.getParameter("roomNumber");
String cardCode = (String) request.getParameter("cardCode");



HotelRoomLockServiceImpl roomlock = new HotelRoomLockServiceImpl(); 
SecretKeyProvider secretKeyProvider = new SecretKeyProviderImpl();
roomlock.setSecretKeyProvider(secretKeyProvider);
roomlock.setRoomNumber(roomNumber);
Boolean accessGranted = roomlock.unlockDoor(cardCode);

%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Door Lock Page</title>
    </head>
    <body>
        <h1>Door Lock</h1>

        <form action="./DoorLockPage.jsp">
            Enter Room Number:<br>
            <input type="text" name="roomNumber" value="<%=roomNumber%>"> 
            <br>
            Enter Card Code:<br>
            <input type="text" name="cardCode" size="100" value="<%=cardCode%>">
            <br>
            <input type="submit" value="Unlock Door">
            <% if(accessGranted){%>
            
            <p>Door unlocked</p>  
            
            <%} else{%> 
            
            <p>Card code invalid. Please try again.</p>
            
            <%  }%>
            
        </form> 
         <br>
        <div id="result"></div>

    </body>
</html>
