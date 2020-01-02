let removeTimetable;
let addTimetables=[];
let i=0;
let messages=document.querySelectorAll(".springMessage");
let container=document.getElementById("container");


function addTimetable(){

    let uri=`${window.location.protocol}//${window.location.host}/rest/save`;
    let request=new XMLHttpRequest();

    request.open("POST",uri);
    request.onload=function(){
        if(request.status==200){

        }
    };

    request.setRequestHeader("Content-Type","application/json");
    request.send(JSON.stringify(addTimetables));
    i=0;
    addTimetables=[];
    location.reload();

}


function Timetable(companyName,departureTime,arrivalTime){
    this.companyName=companyName;
    this.departureTime=departureTime;
    this.arrivalTime=arrivalTime;

}

function createForm() {

    let form=` <div  id="form" class="form-group form col-lg-4 col-lg-offset-4" >
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><p>${messages[0].innerHTML}</p></span>
                        <input  type="text" id="companyName"  placeholder=${messages[0].innerHTML}  class="form-control " /><br>
                    </div><br>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><p>${messages[1].innerHTML}</p></span>
                        <input  type="text" id="departureTime" class="form-control "  placeholder=${messages[6].innerHTML} />

                    </div><br>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><p>${messages[2].innerHTML}</p></span>
                        <input  type="text" id="arrivalTime" class="form-control  "  placeholder=${messages[6].innerHTML} />

                    </div><br>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><p${messages[3].innerHTML}></p></span>
                        <button id="create" onclick="setTimetable()" class="form-control btn btn-primary " >${messages[3].innerHTML}</button>
                    </div>
                </div>`
    container.innerHTML=form;
}

function setTimetable() {
    let companyName=document.getElementById("companyName").value;
    let departureTime=document.getElementById("departureTime").value;
    let arrivalTime=document.getElementById("arrivalTime").value;

    addTimetables[i]=new Timetable(companyName,departureTime,arrivalTime);

    if(document.getElementById("timetable")!=undefined){
        displayTable();
        return
    }
    createTable();

}

function createTable(){

    let table=` <table  id="timetable" class="table tableContent table-striped table-bordered table-hover">

                  
                    <th class="info col-lg-6">
                        <h4 class="text-center" >N</h4>
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
    container.innerHTML=container.innerHTML+table;
    displayTable();
}


function displayTable(){

    let timetable=document.getElementById("timetable");
    timetable.innerHTML=`${timetable.innerHTML}
                        <tr id="${i}">
                            <td ><h4 class="text-center"  >${i}</h4></td>
                            <td ><h4 class="text-center"  >${addTimetables[i].companyName}</h4></td>
                            <td><h4 class="text-center ">${addTimetables[i].departureTime}</h4></td>
                            <td><h4 class="text-center"  >${addTimetables[i].arrivalTime}</h4></td>
                            
                        </tr>`

    i++;
    let submitButton=document.getElementById("submit");

    if(submitButton!=undefined){
        return;
    }
    container.innerHTML=`${container.innerHTML}
                    <div class="input-group input-group-lg col-lg-4 col-lg-offset-4">
                    <button id="submit" class="form-control btn btn-primary " placeholder="Username">${messages[5].innerHTML}</button>

                </div>`
    document.getElementById("submit").onclick=addTimetable;

}

function deleteTimetable() {
    let url=`${window.location.protocol}//${window.location.host}/rest/delete`;
    let request=new XMLHttpRequest();
    request.open("DELETE",url);
    setDeleteTimetable();
    request.onload=function(){
        if(request.status==200){

        }
    };
    request.setRequestHeader("Content-Type","application/json");
    request.send(JSON.stringify(removeTimetable));
    location.reload();
}

function createDeleteForm(){
    createForm();
    let deleteButton=document.getElementById("create");
    deleteButton.onclick=deleteTimetable;
    deleteButton.innerHTML=messages[4].innerHTML;
}

function setDeleteTimetable(){
    let companyName=document.getElementById("companyName").value;
    let departureTime=document.getElementById("departureTime").value;
    let arrivalTime=document.getElementById("arrivalTime").value;

    removeTimetable=new Timetable(companyName,departureTime,arrivalTime);
}
