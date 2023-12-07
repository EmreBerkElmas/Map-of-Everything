// Function to display country list on the web page
function displayCountryList(countryList) {
    const countryListContainer = document.getElementById('country-list'); // Container element in your HTML

    // Clear previous content
    countryListContainer.innerHTML = '';

    countryList.forEach(country => {
        const countryData = document.createElement('div');
        countryData.textContent = JSON.stringify(country); // Convert country data to string

        // Append each country data to the container
        countryListContainer.appendChild(countryData);
    });
}

var map = L.map('map').setView([0, 0], 2);

map.createPane('labels');
        map.getPane('labels').style.zIndex = 650;
        map.getPane('labels').style.pointerEvents = 'none';

      
        L.tileLayer('', {
            attribution: ''
        }).addTo(map);


fetch('/GeoJSON/ne_50m_admin_0_countries.geojson')
.then(function(response) {
    return response.json();
})
.then(function(data) {
    L.geoJSON(data, {
        onEachFeature: function (feature, layer) {
            layer.on('click', function (e) {
                var countryName = feature.properties.NAME;

                document.getElementById("country-name").innerText = countryName;

                fetch('/updateCountryName', {
                    method: 'POST',
                    body: JSON.stringify({ countryName: countryName }),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                .then(function(response) {
                    return response.json();
                })
                .then(function(data) {
                    // Check the result and display country list if necessary
                    if (data.countryExists) {
                        displayCountryList(data.countryList);
                    }
                })
                .catch(function(error) {
                    console.error('Error:', error);
                });
            });
        }
    }).addTo(map);
});
