let scriptcode_e = document.getElementById("scriptcode");
let businessrulename_e = document.getElementById("businessrulename");
let ruletype_e = document.getElementById("ruletype");
let comparevalue_e = document.getElementById("comparevalue");
let operator_e = document.getElementById("operator");
let columnvalue_e = document.getElementById("columnvalue");
let tablevalue_e = document.getElementById("tablevalue");
let exception_e = document.getElementById("exception");
let table = document.getElementById("infoTable")
initPage();

function bevestig() {
    let scriptcode = scriptcode_e.value;
    let businessrulename = businessrulename_e.value;
    let ruletype = ruletype_e.value;
    let comparevalue = comparevalue_e.value;
    let operator = operator_e.value;
    let columnvalue = columnvalue_e.value;
    let tablevalue = tablevalue_e.value;
    let exception = exception_e.value;

    let jsonObject = JSON.stringify({"scriptcode": scriptcode, "businessrulename": businessrulename, "ruletype": ruletype, "comparevalue": comparevalue,
        "operator": operator, "columnvalue": columnvalue, "tablevalue": tablevalue, "exception": exception});
    console.log(jsonObject);
     fetch("/attributecomparerule", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonObject
    })
         .then(function (response) {
             return response.json();
         })
         .then(data => console.log(data))
         .catch(error => console.log(error))
    location.reload();
}
function edit() {
    let scriptcode = scriptcode_e.value;
    let businessrulename = businessrulename_e.value;
    let ruletype = ruletype_e.value;
    let comparevalue = comparevalue_e.value;
    let operator = operator_e.value;
    let columnvalue = columnvalue_e.value;
    let tablevalue = tablevalue_e.value;
    let exception = exception_e.value;
    let jsonObject = JSON.stringify({"scriptcode": scriptcode, "businessrulename": businessrulename, "ruletype": ruletype, "comparevalue": comparevalue,
        "operator": operator, "columnvalue": columnvalue, "tablevalue": tablevalue, "exception": exception});
    console.log(jsonObject);
    fetch("/attributecomparerule/" + localStorage.getItem("attributecomparerule"), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonObject
    })
        .then(response => response.json())
        .then(json => {
            return json;
        });
    location.reload();
}
function initPage() {
    localStorage.removeItem("attributecomparerule");
    fetch("/attributecomparerules")
        .then(response => response.json())
        .then(json => {

            let attributecomparerules = json;

            for(let attributecomparerule in attributecomparerules){

                let row = document.createElement("tr")
                let attributecompareruleJson = attributecomparerules[attributecomparerule];
                for (let key in attributecompareruleJson) {
                    let cell = document.createElement("td")
                    cell.textContent = key;
                    row.appendChild(cell);
                }
                let cell = document.createElement("td")
                row.appendChild(cell);
                table.appendChild(row);
                break;
            }

            for(let attributecomparerule in attributecomparerules){

                let row = document.createElement("tr")
                let attributecompareruleJson = attributecomparerules[attributecomparerule];
                for (let key in attributecompareruleJson){

                    let cell = document.createElement("td")
                    cell.textContent = attributecomparerules[attributecomparerule][key];

                    row.appendChild(cell);
                    if(key=="ruleid"){
                        row.onclick = function (){
                            localStorage.setItem("attributecomparerule",attributecompareruleJson[key]);
                            scriptcode_e.value = attributecompareruleJson["scriptcode"];
                            businessrulename_e.value = attributecompareruleJson["businessrulename"];
                            ruletype_e.value = attributecompareruleJson["ruletype"];
                            comparevalue_e.value = attributecompareruleJson["comparevalue"];
                            operator_e.value = attributecompareruleJson["operator"];
                            columnvalue_e.value = attributecompareruleJson["columnvalue"];
                            tablevalue_e.value = attributecompareruleJson["tablevalue"];
                            exception_e.value = attributecompareruleJson["exception"];
                            let editCell = document.getElementById("editCell");
                            editCell.textContent = "Current ruleid: "+localStorage.getItem("attributecomparerule");
                            let editButton = document.getElementById("editButton");
                            editButton.style.display = "block";
                            let bevestigButton = document.getElementById("bevestigButton");
                            bevestigButton.style.display = "none";
                        }

                    }
                }
                let cell = document.createElement("td");
                cell.textContent = "DELETE";
                cell.style.color = "red";
                cell.style.textAlign= "center";
                let temp = cell.style.backgroundColor;
                cell.onmouseover = function () {
                    cell.style.color = "white";
                    cell.style.backgroundColor = "red";
                }
                cell.onmouseout = function () {
                    cell.style.color = "red";
                    cell.style.backgroundColor = temp;
                }
                cell.onclick = function(event){
                    event.stopImmediatePropagation();
                    fetch("/attributecomparerule/" + attributecompareruleJson["ruleid"], {
                        method: 'DELETE',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                    })
                        .then(function (response) {
                            return response.json();
                        })
                        .then(data => console.log(data))
                        .catch(error => console.log(error));
                    row.style.display = "none";
                }
                row.appendChild(cell);
                table.appendChild(row);
            }
        });

}
function add() {
    localStorage.removeItem("attributecomparerule");
    scriptcode_e.value = "";
    businessrulename_e.value = "";
    ruletype_e.value = "";
    comparevalue_e.value = "";
    operator_e.value = "";
    columnvalue_e.value = "";
    tablevalue_e.value = "";
    exception_e.value = "";
    let editCell = document.getElementById("editCell");
    editCell.textContent = "";
    let editButton = document.getElementById("editButton");
    editButton.style.display = "none";
    let bevestigButton = document.getElementById("bevestigButton");
    bevestigButton.style.display = "block";
}