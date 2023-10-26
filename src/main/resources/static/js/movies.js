// Selecting elements
let container = document.querySelector('.container');
let input = document.querySelector('#title-input');
let yearInput = document.querySelector('#year-input');
let searchBtn = document.querySelector('#search-btn');
let movies = document.querySelector('.movies');
let moviesAll = document.querySelectorAll('single-movie-container');




searchBtn.addEventListener('click', getData)
input.addEventListener('keydown', e => {
	if (e.keyCode == '13') getData();

});
function getData() {


	fetch(`https://www.omdbapi.com/?apikey=da216f55&t="${input.value}"&y=${yearInput.value}`).then(response => {
		if (response.ok) {
			return response.json();
		}
	}).then(data => {


		if (data.Response == 'False') return;
		if (data.Poster === 'N/A') {
			data.poster = 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Image_not_available.png/640px-Image_not_available.png'
		}
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

				method: 'POST',
				headers: {
					'Content-Type': 'application/JSON'
				},
				body: JSON.stringify(data)


			}



		).then(response => response.json()).then(data => {
			window.location.reload();
		});
	});
}