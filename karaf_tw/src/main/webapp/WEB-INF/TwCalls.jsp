<!-- @author Michael Hyun and Sanjana Shetty-->
<!-- There are 8 forms for 8 twitter calls, they all have an action calls which connected from from servlet to access java class methods-->
<html>
    <body>
        
        <div>
        <h3>Twitter Calls</h3>
        <hr>
        <form name='input' action='/KarafTw/tw' method='post'>
            <label>Blocklist</label>
            <input type='hidden' name="process" value='block'/>
            <input type='submit' value='GET'/>
        </form>
 			<hr>
        <form name='input' action='/KarafTw/tw' method='post'>

            <label>Help Language</label>        
            <input type='hidden' name="process" value='language'/>            
            <input type='submit' value='GET'/>
         </form>

 			<hr>
        <form name='input' action='/KarafTw/tw' method='post'>

            <label>Mute Users List</label>
        	<input type='hidden' name="process" value='mute'/>
            <input type='submit' value='GET'/>
        </form>

			<hr>
        <form name='input' action='/KarafTw/tw' method='post'>

            <label>Help Privacy</label>
            <input type='hidden' name="process" value='privacy'/>
            <input type='submit' value='GET'/>
        </form>

            <hr>
        <form name='input' action='/KarafTw/tw' method='post'>

            <label>Settings</label>
            <input type='hidden' name="process" value='settin'/>
            <input type='submit' value='GET'/>
        </form>

             <hr>
        <form name='input' action='/KarafTw/tw' method='post'>

            <label>Suggestions</label>
            <input type='hidden' name="process" value='suggest'/>
            <input type='submit' value='GET'/>
        </form>

             <hr>
         <form name='input' action='/KarafTw/tw' method='post'>

			<label>Followers List</label>
            <input type='hidden' name="process" value='followers'/>
            <input type='submit' value='GET'/>
        </form>

             <hr>
         <form name='input' action='/KarafTw/tw' method='post'>
            <label>Timeline Mention</label>
            <input type='hidden' name="process" value='timeline'/>
            <input type='submit' value='GET'/>
        </form>
        
        </div>        
      
    </body>
</html>

<style>

div{
	position: relative;
	border: 2px solid blue;
    border-radius: 5px;
    top:5px;
	width: 25%;
	margin:auto;
	height: auto;
}
label{
	margin:center;
}
</style>
