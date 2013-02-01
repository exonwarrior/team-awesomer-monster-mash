<%-- 
    Document   : MyMonsters
    Created on : 08-Dec-2012, 18:27:08
    Author     : thh21
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.Monster"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, servlets.MyMonsterServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <link rel="stylesheet" href="style.css" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>My Monsters</title>
            <script type="text/javascript"><!--
                function breedOffer(id){
                
                    document.getElementById("current_action").value = "breed";
                    document.getElementById("breed id").value = id;
                    document.getElementById("current monster id").value =  id;
                    document.forms["monster form"].submit();
                }
                
                function saleOffer(id){
                    var money = document.getElementById("price").value;
                    var moneyReg = /([0-9]{1,8})/;
                    
                    if(!moneyReg.test(money) || money<=0){
                        alert("Not a valid price!");
                    }
                    else {
                        document.getElementById("sale id").value= id;
                        document.getElementById("current_action").value = "sale";
                        document.getElementById("current monster id").value =  id;
                        document.forms["monster form"].submit();
                    }
                }
                function changeMonster(id){
                    document.getElementById("current_action").value = "changeMonster";
                    document.getElementById("current monster id").value =  id;                   
                    document.forms["monster form"].submit();
                }
                
                function refresh(){
                    document.forms
                }
                function logOut(){
                    document.getElementById("logout").value = "logout";
                    document.forms["login"].submit();
                }
                function breedMyMonster(id){
                    document.getElementById("current_action").value = "breed_with_monster";
                    document.getElementById("current monster id").value =  id;                   
                    document.forms["monster form"].submit();
                }
                function fightMyMonster(id){
                    document.getElementById("current_action").value = "fight_with_monster";
                    document.getElementById("current monster id").value =  id;                   
                    document.forms["monster form"].submit();
                }
                
                -->
            </script>
    </head>
    <body>
        <div class="container">
            <div id="navbar">
                <jsp:include page="navbar.jsp" />
            </div>

            <section id="content">
                <h1>Monsters</h1>
                <form method="post" action="myMonsters" id="change_monster">
                    <div class="monsters">
                        <input type="hidden" id="current monster id" name="current monster id" />
                        <input type="hidden" id="breed id" name="breed id" />
                        <input type="hidden" id="sale id" name="sale id" />
                        <input type="hidden" id="current_action" name="current_action" />
                        <table name="monster" border="1">
                            <% ArrayList<Monster> monsters = (ArrayList<Monster>) session.getAttribute("monsters");%>
                            <%DecimalFormat df = new DecimalFormat("#.##");%>
                            <tr>
                                <th>Monster Name</th>

                            </tr>
                            <% if (monsters != null) {
                                    for (Monster monster : monsters) {%>
                            <tr>
                                <td>
                                    <input type="submit" class="button" onclick="changeMonster(<%=monster.getId()%>);" value="<%=monster.getName()%>"  />                           
                                </td>

                            </tr>
                            <%}
                                }%>
                        </table>
                    </div>
                    <div class="monsters">
                        <p name="display monster"><%
                            if (session.getAttribute("current monster") != null) {
                                Monster currentMonster = (Monster) session.getAttribute("current monster");%>
                            Monster Name:   <%=currentMonster.getName()%> <br />
                            Strength:       <%=df.format(currentMonster.getCurrentStrength())%>/<%=df.format(currentMonster.getBaseStrength())%> <br />
                            Defence:        <%=df.format(currentMonster.getCurrentDefence())%>/<%=df.format(currentMonster.getBaseDefence())%> <br />
                            Health:         <%=df.format(currentMonster.getCurrentHealth())%>/<%=df.format(currentMonster.getBaseHealth())%> <br />

                            Breed Offer:    <%=currentMonster.getBreedOffer()%> 
                            <input type="text" placeholder="breeding price" name="breed price" />
                            <input type="submit" class="button" name="breed" onclick="breedOffer(<%=currentMonster.getId()%>);" value="breed" /> <br />

                            Sale Offer:     <%=currentMonster.getSaleOffer()%>
                            <input type="text" id="price" placeholder="selling price" name="sale price" />
                            <input type="submit"  class="button" name="sale"  onclick="saleOffer(<%=currentMonster.getId()%>);" value="sale" />

                            <%if (session.getAttribute("current_action") != null && session.getAttribute("current_action").equals("breed")) {%>
                            <input type="submit" class="button" name="breed"  onclick="breedMyMonster(<%=currentMonster.getId()%>);" value="breed with me" />    
                            <%}%>
                            <%if (session.getAttribute("current_action") != null && session.getAttribute("current_action").equals("fight")) {%>
                            <input type="submit" class="button" name="fight"  onclick="fightMyMonster(<%=currentMonster.getId()%>);" value="fight with me" />    
                            <%}%>

                            <%}%>
                        </p>
                    </div>

                </form>

                <textarea rows="10" cols="50"></textarea>
            </section>
        </div>
    </body>
</html>
