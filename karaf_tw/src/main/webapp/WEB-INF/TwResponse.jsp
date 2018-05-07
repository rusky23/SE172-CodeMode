<!-- @author Michael Hyun and Sanjana Shetty-->
<html>
    <body>        
        <h1>Twitter Response Call</h1>
        
        <button onclick="goBack()">Back</button>
        <div>
        <!-- res is response that is retrieved from TwServlet class-->
        ${res}
   	    </div>
    </body>
</html>

<!-- return back to the homepage-->
<script>
function goBack() {
    window.history.back();
}
</script>

<style>
div{
	position: relative;
	border: 2px solid blue;
    border-radius: 5px;
    top:5px;
	width: auto;
	height: auto;
}
</style>