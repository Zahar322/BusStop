
let timetable=[];


function addTimetable(){

    var uri=`${window.location.protocol}//${window.location.host}/rest/save`;
    var request=new XMLHttpRequest();
    request.open("POST",uri);
    request.onload=function(){
        if(request.status==200){

        }
    };
    setTimetable();
    alert(JSON.stringify(timetable));
    request.setRequestHeader("Content-Type","application/json");
    request.send(JSON.stringify(timetable));

}


function Timetable(companyName,departureTime,arrivalTime){
    this.companyName=companyName;
    this.departureTime=departureTime;
    this.arrivalTime=arrivalTime;

}

function createForm() {
    let messages=document.querySelectorAll(".springMessage");
    let container=document.getElementById("container");
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
                        <button id="create" onclick="addTimetable()" class="form-control btn btn-primary " >${messages[3].innerHTML}</button>
                    </div>
                </div>`
    container.innerHTML=form;
}

function setTimetable() {
    let companyName=document.getElementById("companyName").value;
    let departureTime=document.getElementById("departureTime").value;
    let arrivalTime=document.getElementById("arrivalTime").value;

    timetable[0]=new Timetable(companyName,departureTime,arrivalTime);
    timetable[1]=new Timetable(companyName,departureTime,arrivalTime);
}
