// Selecting elements
let container = document.querySelector('.container');
let input = document.querySelector('input');
let searchBtn = document.querySelector('#search-btn');
let movies = document.querySelector('.movies');








searchBtn.addEventListener('click',() => {



let movie = {};
fetch(`http://www.omdbapi.com/?apikey=da216f55&t="${input.value}"`).then(response => {
if(response.ok){
    return response.json();
}
}).then(data => {
    console.log(data)
   movie = data;
   if(data.Response == 'False') return;
   let img = `
   <div class="single-movie-container">
   <h3>${data.Title}</h3>
   <span>${data.Year}</span>
   <img class="poster" src="${data.Poster}"/>
   <button>See more!</button>
   </div>
   
   
   
   
   `;
    
   movies.innerHTML += img;

   fetch('/movies',
   {

       method:'POST',
       headers:{
           'Content-Type':'application/JSON'
       },
       body:JSON.stringify(data)


   }



).then(response => response.json()).then(data => {
   window.location.reload();
});
});
})

