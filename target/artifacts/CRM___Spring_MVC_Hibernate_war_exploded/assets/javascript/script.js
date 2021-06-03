'use strict';

const deleteButton = document.querySelectorAll('.delete');

deleteButton.forEach((btn) => {
    btn.addEventListener('click', () => {
        confirm("Do you really want to delete this?");
    })
})