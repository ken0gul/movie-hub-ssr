// // Selecting elements
let watchedBtn = document.querySelectorAll('.watched-btn');
let userId = document.querySelector('ul[data-user-id]').getAttribute('data-user-id');


watchedBtn.forEach(btn => {
    btn.addEventListener('click', (e) => {
       let movieId = e.currentTarget.previousElementSibling.children[0].getAttribute('data-movie-id');
     	console.log(movieId);

        let movie = {
            "movieId":movieId,
            "userId":userId
        }

        fetch(`/user/${userId}/delete`,{
            method:'POST',
            headers:{
                'Content-Type':'application/JSON'
            },
            body:JSON.stringify(movie)
        }).then(response => response.json()).then(data => window.location.reload());
    })
})
