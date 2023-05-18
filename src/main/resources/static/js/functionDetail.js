
(function () {
    let detailBtn = document.querySelectorAll(".detailBtn");
    for (var i = 0; i < detailBtn.length; i++) {
        detailBtn[i].addEventListener("click", function (event) {
            detailBtn = event.target;
            let projectId = detailBtn.getAttribute("data-id");
            requestSingleProject(projectId);
        });
    }

    //if close button is clicked
            let span = document.getElementsByClassName("close");
            for (var i = 0; i < span.length; i++) {
                span[i].onclick = function () {
                    modal.style.display = "none";
                }
            }

            let span1 = document.getElementsByClassName("close1");
            for (var i = 0; i < span1.length; i++) {
                span1[i].onclick = function () {
                    modalDetail.style.display = "none";
                }
            }

              // When the user clicks anywhere outside of the modal, close it
              window.onclick = function(event) {
                if (event.target == modal) {
                  modal.style.display = "none";
                }
              }

              window.onclick = function(event) {
                if (event.target == modalDetail) {
                  modalDetail.style.display = "none";
                }
              }
})();


function requestSingleProject(projectId) {
  let actionUrl = `http://localhost:8080/project/find-by-id/2`;

  let request = new XMLHttpRequest();
  request.open("GET", actionUrl);
  request.send();
  request.onload = function () {
    let project = JSON.parse(request.responseText);
//    console.log(product);
    fillDetailInformation(project);

    let modalDetail = document.getElementById("modalDetail");
    modalDetail.style.display = "block";
  };
}

function fillDetailInformation({
  namaProject
//  categoryName,
//  description,
//  unitPrice,
//  sellerName,
}) {
  document.querySelector(".modal-body .namaProject").textContent =
    namaProject;

//  document.querySelector(".modal-content2 .categoryName").textContent =
//    categoryName;
//
//  document.querySelector(".modal-content2 .description").textContent =
//    description;
//
//  document.querySelector(".modal-content2 .unitPrice").textContent =
//    unitPrice;
//
//  document.querySelector(".modal-content2 .sellerName").textContent =
//    sellerName;
}
