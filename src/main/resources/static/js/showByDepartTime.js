
let timetables;

let showServiceActions=document.querySelectorAll(".showAction");

window.onload=()=> {
    showServiceActions.forEach(action=>{
        action.onclick=()=>{
            getServiceOrderByDepartureTime(action.getAttribute("name"));
        }
    })
}

function getServiceOrderByDepartureTime(uri) {
    let url=`${window.location.protocol}//${window.location.host+uri}`;
    let request=new XMLHttpRequest();
    request.open("GET",url);
    request.onload=function(){
        if(request.status==200){
            setTimetables(request.responseText);
            displayTimetable();
        }
    };
    request.send(null);
}

function deleteC() {
    let url=`${window.location.protocol}//${window.location.host}/rest/delete/2`;
    let request=new XMLHttpRequest();
    request.open("DELETE",url);
    request.onload=function(){
        if(request.status==200){

        }
    };
    request.send(null);
}



function setTimetables(jsonTimetables){
    timetables=JSON.parse(jsonTimetables);
}

function createTableForTimetable() {
    let messages=document.querySelectorAll(".springMessage");
    let container=document.getElementById("container");
    let table=` <table  id="timetable" class="table tableContent table-striped table-bordered table-hover">

                    <th class="success col-lg-1">
                        <h4 class="text-center">Id</h4>
                    </th>

                    <th class="info col-lg-6">
                        <h4 class="text-center" >${messages[0].innerHTML}</h4>
                    </th>
                    <th class="danger col-lg-1">
                        <h4 class="text-center" >${messages[1].innerHTML}</h4>
                    </th>
                    <th class="danger col-lg-1">
                        <h4 class="text-center" >${messages[2].innerHTML}</h4>
                    </th>


                </table>`;
    container.innerHTML=table;
}


function displayTimetable(){
    createTableForTimetable();
    let timetable=document.getElementById("timetable");
    for(let i=0;i<timetables.length;i++){
        timetable.innerHTML=`${timetable.innerHTML}
                        <tr>
                            <td ><h4 class="text-center" >${timetables[i].id}</h4></td>
                            <td ><h4 class="text-center"  >${timetables[i].companyName}</h4></td>
                            <td><h4 class="text-center ">${timetables[i].departureTime}</h4></td>
                            <td><h4 class="text-center"  >${timetables[i].arrivalTime}</h4></td>
                        </tr>`

    }
}

