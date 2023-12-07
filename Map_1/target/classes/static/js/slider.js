var slider = document.getElementById("myRange");
var output = document.getElementById("demo");
output.innerHTML = slider.value;

slider.oninput = function() {
  output.innerHTML = this.value;
}

function sendToBackend(){
    var selectedValue = document.getElementById("demo").innerHTML;

    fetch('/updateSliderValue', {
        method:'POST',
        body: JSON.stringify({value : selectedValue}),
        headers:{
            'Content-Type': 'application/json'
        }

    }
    )
}