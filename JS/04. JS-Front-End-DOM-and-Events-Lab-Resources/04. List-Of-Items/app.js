function addItem() {
   let liText = document.getElementById("newItemText").value;
   let li = document.createElement("li");
   
   li.textContent = liText;

   let elem = document.getElementById("items");
   elem.appendChild(li);
   document.getElementById("newItemText").value = "";
}