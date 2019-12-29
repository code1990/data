var dbtable = document.getElementById("dbtable");
var tbody = dbtable.getElementsByTagName("tbody")[0];
var trs = tbody.getElementsByTagName("tr");
for(var i=0;i<trs.length;i++){
	var tds = trs[i].getElementsByTagName("td");
	var number = tds[1].innerText;
	var code = tds[2].innerText;
	var name = tds[3].innerText;
	console.log(number+"\t"+code+"\t"+name);
}