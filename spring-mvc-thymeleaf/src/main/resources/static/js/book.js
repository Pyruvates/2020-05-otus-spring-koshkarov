'use strict'

function selectGenre() {
    document.getElementById('genre-input').value = document.getElementById('genre-select').value;
}

function selectAuthor() {
    let authorFullName = document.getElementById('author-select').value.split(' ');
    document.getElementById('author-firstname-input').value = authorFullName[0];
    document.getElementById('author-lastname-input').value = authorFullName[1];
}