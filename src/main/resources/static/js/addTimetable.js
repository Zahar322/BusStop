
let addTimetables=[];
let saveTimetables=[];
let i=0;
let messages=document.querySelectorAll(".springMessage");
let container=document.getElementById("container");


function addTimetable(){

    let uri=`${window.location.protocol}//${window.location.host}/rest/save`;
    let request=new XMLHttpRequest();
    let showTimetable=document.getElementById("showTimetable");
    request.open("POST",uri);
    request.onload=function(){
        if(request.status==200){

        }
    };
   // setTimetable();
   //  for(let i=0;i<addTimetables.length;i++){
   //      if(addTimetables[i]==null||addTimetables[i]==undefined){
   //          continue;
   //      }
   //      saveTimetables[i]=addTimetables[i];
   //  }
   //  alert(saveTimetables);
    request.setRequestHeader("Content-Type","application/json");
    request.send(JSON.stringify(addTimetables));
    i=0;
    addTimetables=[];
    showTimetable.click();

}


function Timetable(companyName,departureTime,arrivalTime){
    this.companyName=companyName;
    this.departureTime=departureTime;
    this.arrivalTime=arrivalTime;

}

function createForm() {

    let form=` <div  id="form" class="form-group form col-lg-4 col-lg-offset-4"  >
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><p>${messages[0].innerHTML}</p></span>
                        <input  type="text" id="companyName"  placeholder=${messages[0].innerHTML}  class="form-control " /><br>
                    </div><br>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><p>${messages[1].innerHTML}</p></span>
                        <input  type="text" id="departureTime" class="form-control "  placeholder=${messages[1].innerHTML} />

                    </div><br>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><p>${messages[2].innerHTML}</p></span>
                        <input  type="text" id="arrivalTime" class="form-control  "  placeholder=${messages[2].innerHTML} />

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

    // timetable[1]=new Timetable(companyName,departureTime,arrivalTime);

}

function createTable(){
    // let messages=document.querySelectorAll(".springMessage");
    // let container=document.getElementById("container");
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
                     <th class="danger col-lg-1">
                        <h4 class="text-center" >${messages[4].innerHTML}</h4>
                    </th>


                </table>`;
    container.innerHTML=container.innerHTML+table;
    displayTable();
}

function addDeleteAction(deleteButton) {

    deleteButton.onclick=()=>{
        alert("retard");
        let rowService=document.getElementById(deleteButton.getAttribute("name"));
        alert(rowService);
        rowService.parentNode.removeChild(rowService);
        let idService=parseInt(deleteButton.getAttribute("name"));
        addTimetables.splice(idService,1);
    }
    //deleteButton.onclick=deleteService(deleteButton);
}
// function deleteService(button){
//     let rowService=document.getElementById(button.getAttribute("name"));
//     rowService.parentNode.removeChild(rowService);
//     let idService=parseInt(button.getAttribute("name"));
//     addTimetables.splice(idService,1);
//
// }

function displayTable(){

    let timetable=document.getElementById("timetable");
    timetable.innerHTML=`${timetable.innerHTML}
                        <tr id="${i}">
                            <td ><h4 class="text-center"  >${i}</h4></td>
                            <td ><h4 class="text-center"  >${addTimetables[i].companyName}</h4></td>
                            <td><h4 class="text-center ">${addTimetables[i].departureTime}</h4></td>
                            <td><h4 class="text-center"  >${addTimetables[i].arrivalTime}</h4></td>
                            <td><h4 class="text-center"  ></h4> <button name="${i}" class="form-control btn btn-primary delete${i}" placeholder="Username">${messages[4].innerHTML}</button></td>
                        </tr>`
   // addDeleteAction(document.querySelector(`.delete${i}`));
    i++;
    let submitButton=document.getElementById("submit");

    if(submitButton!=undefined){
        return;
    }
    container.innerHTML=`${container.innerHTML}
                    <div class="input-group input-group-lg col-lg-4 col-lg-offset-4">
                    <button id="submit" class="form-control btn btn-primary " placeholder="Username">Заказать</button>

                </div>`
    document.getElementById("submit").onclick=addTimetable;

}
