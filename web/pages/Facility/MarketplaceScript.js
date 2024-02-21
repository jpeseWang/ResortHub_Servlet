
 document.addEventListener('DOMContentLoaded', function() {
        const filterButtons = document.querySelectorAll('.filter-button');
        const facilityItems = document.querySelectorAll('.facility-item');

        filterButtons.forEach(function(button) {
            button.addEventListener('click', function() {
                const type = this.getAttribute('data-type');

                facilityItems.forEach(function(item) {
                    if (type === 'All' || item.getAttribute('data-type') === type) {
                        item.style.display = 'block';
                    } else {
                        item.style.display = 'none';
                    }
                });
            });
        });
    });

function toggleSort() {
    var navigation = document.querySelector(".sort-selection");
    navigation.classList.toggle("hidden");
}

function toggleColor() {
    var navigation = document.querySelector(".color-selection");
    navigation.classList.toggle("hidden");
}

function toggleSize() {
    var navigation = document.querySelector(".size-selection");
    navigation.classList.toggle("hidden");
}