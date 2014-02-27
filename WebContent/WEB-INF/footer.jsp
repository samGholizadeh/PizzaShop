
    
      <div style="margin-top: 20px;" class="footer">
        <p>&copy; Pizza butiken</p>
      </div>

    </div>
    <script src="resources/js/jquery-2.1.0.js"></script>
    <script src="resources/js/jquery-2.1.0.min.map"></script>
    <script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/homecooked.js"></script>
    <script>
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
    </script>
  </body>
</html>