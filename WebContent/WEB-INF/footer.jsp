
    
      <div style="margin-top: 20px;" class="footer">
        <p>&copy; Pizza butiken</p>
      </div>

    </div>
    <script src="resources/js/jquery-2.1.0.js"></script>
    <script src="resources/js/jquery-2.1.0.min.map"></script>
    <script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/homecooked.js"></script>
    <script>
    $("#jsElement").hide();
	$("#pizzaAmount").on("change", function(){
		var selectedValue = this.value;
		for(var i = 2; i <= selectedValue; i++){
			$("#pizzaTemplate").clone().insertAfter("#pizzaTable tr:last");
			$("#pizzaTable tr:last select").attr("name", "pizzaid"+i);
			$("input[name='pizzaAmount']").val(""+i);
		}
	});
	$("#drinkAmount").on("change", function(){
		var selectedValue = this.value;
		for(var i = 2; i <= selectedValue; i++){
			$("#drinkTemplate").clone().insertAfter("#drinkTable tr:last");
			$("#drinkTable tr:last select").attr("name", "drinkid"+i);
			$("input[name='drinkAmount']").val(""+i);
		}
	});
	
	window.onload = function(){
		
		document.getElementById("javaScript").onclick = function(){
			var element = document.getElementById("jsElement");
			
			if(element){
				var style = element.style.display;
				if(style == "none"){
					element.style.display = "block";
				} else {
					element.style.display = "none";
				}
			}
		}
		
		document.getElementById("calculateYearlyIncome").onclick = function(){
			var income = document.getElementById("income").value;
			income = parseInt(income);
			income *= 12;
			alert("Din årliga inkomst är: "+income+"kr.");
		}
	}
    </script>
  </body>
</html>