const map = L.map('map', {
    crs: L.CRS.Simple,
    minZoom: -1,
    zoomControl: false
});
L.control.zoom({ position: 'bottomright' }).addTo(map);

const bounds = [[0, 0], [800, 1000]];
const image = L.imageOverlay('Ground Map1.jpg', bounds).addTo(map);
map.fitBounds(bounds);

var locations = {
            'CL-001': [7, 2.5],
            'CL-002': [7, 4.21],
            'CL-003':[11.9,1.3],
            'CL-004': [13.3, 1.3],
            'CL-005': [15, 1.5],
            'CL-006': [15, 2.9],
            'CL-007': [15, 3.2],
            'CL-008': [15, 4.5],
            'CL-009': [10.9,3.8],
            'STAFF1': [8.9, 3.8],
            'STAFF2': [10.3, 2.5],
            'CAD LAB': [12, 7.5],
            'LAB1': [15, 8.7],
            'GIRLS WASHROOM': [14, 5.5],
            'BOYS WASHROOM': [14, 7.5],
            'GANAPATHI': [4.5, 14.7],
            'SEMINAR HALL 2': [15, 11],
            'LIBRARY': [7, 23.5],
            'OFFICE': [13, 21.3],
            'SEMINAR HALL 1': [7.3, 19],
            'PRINCIPAL CABIN': [3.7, 13.7],
            'CONFERENCE HALL': [4.5,15.8 ],
            'PLACEMENT OFFICE': [10.3, 15.7],
            'BOARD ROOM': [9.8, 13.7],
            'DEAN OFFICE': [6.4, 8],
            'MEETING ROOM': [15.7, 13.5],
            'PI ROOM': [15.7, 15.7],
            'LIFT1':[8.1,1.9],
            'STAIRS1':[8.5,2.3],
            'STAIRS2':[13.4,12.5]
        };

        const locationImages = {
    'CL-001': 'images/CL-001.jpg',
    'CL-008': 'images/CL-008.jpg',
    'CL-007': 'images/CL-007.jpg',
    'CL-002': 'images/CL-002.jpg',
    'CL-003': 'images/CL-003.jpg',
    'CL-004': 'images/CL-004.jpg',
    'CL-005': 'images/CL-005.jpg',
    'CL-006': 'images/CL-006.jpg',
    'STAFF1': 'images/STAFF1.jpg',
    'STAFF2': 'images/STAFF2.jpg',
    'CAD LAB': 'images/CAD-LAB.jpg',
    'LAB1': 'images/LAB1.jpg',
    'GIRLS WASHROOM': 'images/GIRLS-WASHROOM.png',
    'BOYS WASHROOM': 'images/BOYS-WASHROOM.png',
    'GANAPATHI': 'images/GANAPATHI.png',
    'SEMINAR HALL 2': 'images/SEMINAR-HALL-2.png',
    'LIBRARY': 'images/LIBRARY.png',
    'OFFICE': 'images/OFFICE.png',
    'SEMINAR HALL 1': 'images/SEMINAR-HALL-1.png',
    'PRINCIPAL CABIN': 'images/PRINCIPAL-CABIN.png',
    'CONFERENCE HALL': 'images/CONFERENCE-HALL.png',
    'PLACEMENT OFFICE': 'images/PLACEMENT-OFFICE.png',
    'BOARD ROOM': 'images/BOARD-ROOM.png',
    'DEAN OFFICE': 'images/DEAN-OFFICE.png',
    'MEETING ROOM': 'images/MEETING-ROOM.png',
    'PI ROOM': 'images/PI-ROOM.png'
};


        var junctions = {
            'j1': [7., 3.2],
            'j2': [8.1, 3.2],
            'j3': [8.1, 2.3 ],
            'j4': [8.9, 3.2],
            'j5': [10.3, 3.2],
            'j6': [10.9, 3.2],
            'j7':[11.55, 3.2],
            'j8': [12.5, 3.2],
            'j9': [13.1, 3.2],
            'j10': [13.1, 2.5],
            'j11': [13.1, 1.6],
            'j12': [13.3, 1.6],
            'j13':[14.5,1.6],
            'j14':[14.8,1.6],
            'j15':[14.8, 2.9],
            'j16':[14.8, 3.3], 
            'j17':[14.5,3.1],
            'j18':[13.7,3.2], 
            'j19':[14.8, 4],
            'j20':[14.8,4.4],
            'j21':[14.8,4.6],
            'j22': [14,4.6],
            'j23':[13.1,4.6],
            'j24':[13.1,5.6],
            'j25':[13.1,7.5],
            'j26':[13.1,9.1],
            'j27':[13.1,9.6],
            'j28':[13.1,11],
            'j29':[13.1,12.5],
            'j30':[14,9.1],
            'j31':[11.9,1.6],
            'j32':[12.5,1.6],
            'j33':[13.1,14.7],
            'j34':[15.7,14.7],
            'j35':[13.1,16.4],
            'j36':[10.3,14.7],
            'j37':[11.9,14.7],
            'j38':[9.8,14.7],
            'j39':[6.4,14.7],
            'j40':[9.8,9.6],
            'j41':[6.4,9.6],
            'j42':[6.4,18],
            'j43':[7.3,18],
            'j44':[7.3,18.8],
            'j45':[6.4,18.8],
            'j46':[6.4,21.3],
            'j47':[6.4,23.5],
            'j48':[9.8,21.3],
            'j49':[11.5,21.3],
            'j50':[12.4,21.3],
            'j51':[5.3,14.7],
            'j52':[5.3,15.2],
            'j53':[4.5,15.2],
            'j54':[3.6,15.2],
            'j55':[3.6,14],
            'j56':[4.5,14],
            'j57':[5.3,14],
            'j58':[13.1,2]
        };

        var connections = {
            'j1': ['j2'],
            'j2': ['j1', 'j3','j4'],
            'j3': ['j2'],
            'j4': ['j2', 'j5'],
            'j5': ['j4', 'j6'],
            'j6': ['j5', 'j7'],
            'j7': ['j6', 'j8'],
            'j8': ['j7', 'j9'],
            'j9': ['j8', 'j10','j18','j23'],
            'j10': [ 'j9', 'j11','j58'],
            'j11': ['j58','j12','j32'],
            'j12': ['j11','j13'],
            'j13':['j12','j14'],
            'j14':['j13','j15'],
            'j15':['j14','j16','j17'],
            'j16':['j15','j17','j19'],
            'j17':['j16','j18','j15'],
            'j18':['j17','j9'],
            'j19':['j16','j20'],
            'j20':['j19','j21'],
            'j21':['j20','j22','j23'],
            'j22':['j21','j23'],
            'j23':['j9','j22','j24'],
            'j24':['j23','j25'],
            'j25':['j24','j26'],
            'j26':['j25','j27','j30'],
            'j27':['j26','j28','j40'],
            'j28':['j27','j29'],
            'j29':['j28','j33'],
            'j30':['j26'],
            'j31':['j32'],
            'j32':['j11','j31'],
            'j33':['j29','j34','j35','j37'],
            'j34':['j33'],
            'j35':['j33'],
            'j36':['j37','j38'],
            'j37':['j33','j36'],
            'j38':['j36','j39'],
            'j39':['j38','j41','j42','j51'],
            'j40':['j27','j41'],
            'j41':['j40','j39'],
            'j42':['j39','j43'],
            'j43':['j42','j44'],
            'j44':['j43','j45'],
            'j45':['j44','j46'],
            'j46':['j45','j47','j48'],
            'j47':['j46'],
            'j48':['j47','j49'],
            'j49':['j48','j50'],
            'j50':['j49'],
            'j51':['j39','j52','j57'],
            'j52':['j51','j53'],
            'j53':['j52','j54'],
            'j54':['j53','j55'],
            'j55':['j54','j56'],
            'j56':['j57','j55'],
            'j57':['j56','j51'],
            'j58':['j11','j10']


            
        };

function toggleMenu() {
    const menu = document.getElementById('dropdownMenu');
    menu.style.display = menu.style.display === 'block' ? 'none' : 'block';
}

document.addEventListener('DOMContentLoaded', function() {
    const element = document.getElementById('source');
    const choices = new Choices(element, {
        searchEnabled: true,
        placeholderValue: "Select location...",
    });
});

document.getElementById('toggleSidebar').addEventListener('click', () => {
    const sidebar = document.querySelector('.sidebar');
    sidebar.style.display = sidebar.style.display === 'none' ? 'block' : 'none';
});

function toCoords(loc) {
    return [loc[0] * 40, loc[1] * 40];
}

var junctionIcon = L.icon({
    iconUrl: 'junction.png',
    iconSize: [20, 20],
});

for (var junc in junctions) {
    var coords = toCoords(junctions[junc]);
    L.marker(coords, { icon: junctionIcon }).addTo(map).bindPopup(junc);
}

for (let loc in locations) {
    let option = document.createElement('option');
    option.value = loc;
    option.textContent = loc;
    document.getElementById('source').appendChild(option);

    let option2 = option.cloneNode(true);
    document.getElementById('destination').appendChild(option2);
}



var currentPolyline = null;
var sourceMarker = null;
var destinationMarker = null;
var movingMarker = null;

function heuristic(a, b) {
    return Math.sqrt(Math.pow(junctions[a][0] - junctions[b][0], 2) + Math.pow(junctions[a][1] - junctions[b][1], 2));
}

function calculatePathAStar(start, end) {
    let openSet = [start];
    let cameFrom = {};
    let gScore = {};
    let fScore = {};

    for (let junc in junctions) {
        gScore[junc] = Infinity;
        fScore[junc] = Infinity;
    }
    gScore[start] = 0;
    fScore[start] = heuristic(start, end);

    while (openSet.length > 0) {
        openSet.sort((a, b) => fScore[a] - fScore[b]);
        let current = openSet.shift();

        if (current === end) {
            let path = [];
            while (current in cameFrom) {
                path.push(current);
                current = cameFrom[current];
            }
            path.push(start);
            return path.reverse();
        }

        for (let neighbor of connections[current] || []) {
            let tentative_gScore = gScore[current] + heuristic(current, neighbor);

            if (tentative_gScore < gScore[neighbor]) {
                cameFrom[neighbor] = current;
                gScore[neighbor] = tentative_gScore;
                fScore[neighbor] = gScore[neighbor] + heuristic(neighbor, end);

                if (!openSet.includes(neighbor)) {
                    openSet.push(neighbor);
                }
            }
        }
    }
    return [];
}

function findRoute() {
    if (currentPolyline) map.removeLayer(currentPolyline);
    if (sourceMarker) map.removeLayer(sourceMarker);
    if (destinationMarker) map.removeLayer(destinationMarker);
    if (movingMarker) map.removeLayer(movingMarker);

    const sourceName = document.getElementById('source').value;
    const destinationName = document.getElementById('destination').value;

    if (!sourceName || !destinationName) {
        document.getElementById('instruction-box').textContent =
            'Please select both source and destination to find the route.';
        return;
    }

    const sourceCoords = locations[sourceName];
    const destinationCoords = locations[destinationName];

    const sourceImage = locationImages[sourceName] || 'images/default.png';
    const destinationImage = locationImages[destinationName] || 'images/default.png';

    sourceMarker = L.marker(toCoords(sourceCoords))
        .addTo(map)
        .bindPopup(`
            <b>Source:</b> ${sourceName}<br>
            <img src="${sourceImage}" alt="${sourceName} Image" width="150">
        `);

    destinationMarker = L.marker(toCoords(destinationCoords))
        .addTo(map)
        .bindPopup(`
            <b>Destination:</b> ${destinationName}<br>
            <img src="${destinationImage}" alt="${destinationName} Image" width="150">
        `);

    sourceMarker.openPopup();
    destinationMarker.openPopup();

    const nearestSourceJunction = findNearestJunction(sourceCoords);
    const nearestDestinationJunction = findNearestJunction(destinationCoords);

    const path = calculatePathAStar(nearestSourceJunction, nearestDestinationJunction);

    const latlngs = [toCoords(sourceCoords)];
    path.forEach((junc) => latlngs.push(toCoords(junctions[junc])));
    latlngs.push(toCoords(destinationCoords));

    currentPolyline = L.polyline(latlngs, { color: 'blue', weight: 4 }).addTo(map);

    map.fitBounds(L.latLngBounds(latlngs));

    document.getElementById('instruction-box').textContent = 'Starting navigation...';

    animateMarker(latlngs);
}

function findNearestJunction(coords) {
    var minDist = Infinity, nearestJunction = null;
    for (var junc in junctions) {
        var juncCoords = junctions[junc];
        var dist = Math.pow(juncCoords[0] - coords[0], 2) + Math.pow(juncCoords[1] - coords[1], 2);
        if (dist < minDist) {
            minDist = dist;
            nearestJunction = junc;
        }
    }
    return nearestJunction;
}

function animateMarker(latlngs) {
    let index = 0;
    movingMarker = L.marker(latlngs[index]).addTo(map);

    let instructionBox = document.getElementById('instruction-box');
    instructionBox.style.display = 'block';
    instructionBox.textContent = 'Start moving...';

    let lastInstruction = '';

    function calculateAngle(pointA, pointB) {
        const dy = pointB[0] - pointA[0];
        const dx = pointB[1] - pointA[1];
        let angle = Math.atan2(dy, dx) * (180 / Math.PI);
        return (angle + 360) % 360;
    }

    function getDirection(prevAngle, currentAngle) {
        const delta = (currentAngle - prevAngle + 360) % 360;
        if (delta < 20 || delta > 340) return 'Go straight';
        if (delta > 20 && delta < 160) return 'Turn right';
        if (delta > 200 && delta < 340) return 'Turn left';
        return 'Continue moving';
    }

    function smoothMoveMarker(marker, fromLatLng, toLatLng, duration, callback) {
        const startTime = performance.now();

        function animate() {
            const currentTime = performance.now();
            const elapsed = currentTime - startTime;
            const t = Math.min(elapsed / duration, 1);

            const lat = fromLatLng[0] + (toLatLng[0] - fromLatLng[0]) * t;
            const lng = fromLatLng[1] + (toLatLng[1] - fromLatLng[1]) * t;

            marker.setLatLng([lat, lng]);

            if (t < 1) {
                requestAnimationFrame(animate);
            } else if (callback) {
                callback();
            }
        }

        animate();
    }

    function move() {
        if (index >= latlngs.length - 1) {
            instructionBox.textContent = 'You have arrived at your destination!';
            return;
        }

        const prevLatLng = latlngs[index];
        const currentLatLng = latlngs[index + 1];
        const nextLatLng = latlngs[index + 2] || currentLatLng;

        const prevAngle = calculateAngle(prevLatLng, currentLatLng);
        const currentAngle = calculateAngle(currentLatLng, nextLatLng);
        const instruction = getDirection(prevAngle, currentAngle);

        if (instruction !== lastInstruction) {
            instructionBox.textContent = instruction;
            lastInstruction = instruction;
        }

        const animationDuration = 2000;

        smoothMoveMarker(movingMarker, prevLatLng, currentLatLng, animationDuration, () => {
            index++;
            move();
        });
    }

    move();
}