function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   const searchQuery = document.querySelector("#searchField");
     const cells = Array.from(document.querySelectorAll("tbody tr"));

   function onClick(ev) {   

     for(let cell of cells){
      cell.classList.remove("select");

      if(searchQuery.value !== " " && cell.innerHTML.includes(searchQuery.value)) {
         cell.className = "select";
      }
     }
     searchQuery.value = "";

   }
}