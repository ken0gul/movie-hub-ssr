/**
 * 
 */

let submitForm = document.querySelector('#submit-form');
let updateForm = document.querySelector('#update-form');
let commentText = document.querySelector('.comment-text');
let movieId = document.querySelector('input[data-movie-id]');
let userId = document.querySelector('button[data-user-id]');
let commentId= document.querySelector('input[data-comment-id]');
let movieEndPointId = movieId.getAttribute('data-movie-id');
let userEndPointId=userId.getAttribute('data-user-id');
let commentEndPointId=commentId.getAttribute('data-comment-id');
let editBtns = document.querySelectorAll('.btn-edit');
let updateText= document.querySelector('#update-text');
let likeBtn = document.querySelector('.like-btn');
let dislikeBtn = document.querySelector('.dislike-btn');
let likeContainer = document.querySelector('.like-container');
 // FORMS EDIT - SUBMIT


 likeBtn.addEventListener('click', (e)=> {
    console.log("Clicked");
  	console.log(e);
	

    fetch(`/movie/${movieEndPointId}/user/${userEndPointId}/like`, {
        method:'POST',
    }).then(response => response.json()).then(data => {
        window.location.reload();
        console.log(data);

    });
 })



 dislikeBtn.addEventListener('click',e => {
    fetch(`/movie/${movieEndPointId}/user/${userEndPointId}/unlike`, {
        method:'POST',
    }).then(response => response.json()).then(data => {
        window.location.reload();
    })
 })


 editBtns.forEach(btn => {
    btn.addEventListener('click', e=> {
        submitForm.style.display='none';
    updateForm.style.display='block';
 let currentTarget = e.currentTarget.parentElement.querySelector('p');



  


fetch(`/movie/${movieEndPointId}/user/${userEndPointId}/edit`)
.then(response => response.json())
.then(data => {
    updateText.textContent = currentTarget.textContent;
    console.log(data);
    let comment = {
        "id":commentEndPointId,
        "date":data.date,
        "commentText":updateText.textContent

    }

    return fetch(`/movie/${movieEndPointId}/user/${userEndPointId}/edit`, {
        method:'POST',
        headers:{
            'Content-Type':'application/JSON'
        },
        body:JSON.stringify(comment)
    }).then(response => response.json())
    .then(data=> console.log(data));
});
        
}
 )
 })


