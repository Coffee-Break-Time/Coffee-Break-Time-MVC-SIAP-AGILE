(function () {

    // get all elements with id buttonEdit
    let btnEdit = document.querySelectorAll('#buttonEdit');
    // loop through all buttonEdit elements
    btnEdit.forEach(function (element) {
        // add click event
        element.addEventListener('click', function () {
            // get value of data-id attribute
            let projectId = this.getAttribute('data-id');
            console.log(projectId);
            // call getDataKantor function
            getDataProject(projectId);
        });
    });

    let btnClose = document.querySelector('#btnClose');
    btnClose.addEventListener('click', function () {
        resetValues();
    });

    // get buttonSave element
    let btnSave = document.querySelector('#btnSave');
    // add click event
    btnSave.addEventListener('click', function (e) {
        // e.preventDefault();
        // call saveDataKantor function
        saveDataProject();
    });

//    let btnLogin = document.querySelector('#btnLogin');
//    // add click event
//    btnLogin.addEventListener('click', function (e) {
//        // e.preventDefault();
//        // call loginUser function
//        loginUser();
//    });

    let modalProject = document.querySelector('#modalProject');
    // if modalKantor is hidden, reset the values
    modalProject.addEventListener('hidden.bs.modal', function () {
        resetValues();
    });
})();

// ajax get data Cabang from controller kantor/{projectId}
// where data cabang will be received as th:object in the edit kantor form

function getDataProject(projectId) {
    // get cabang data
    $.get(`http://localhost:8080/project/project/${projectId}`).then(function (data) {
        console.log(data);
        $('#projectId').val(data.projectId);
        /*
        if (data.id != null) {
            var headingElement = document.getElementById('kantorTitle');
            headingElement.textContent = 'Edit Kantor';
            console.log(data.id);
        }
        */
        $('#namaProject').val(data.namaProject);
        $('#namaDepartemen').val(data.namaDepartemen);
        $('#projectOwner').val(data.projectOwner);
        $('#projectManager').val(data.projectManager);
        $('#namaKantor').val(data.namaKantor);
        $('#priority').val(data.priority);
        $('#bobot').val(data.bobot);
        $('#tglMulai').val(data.tglMulai);
        $('#tglSelesai').val(data.tglSelesai);
        $('#description').val(data.description);
        $('#status').val(data.status);
//        if (data.ktrjns == 'Konven') {
//            $('#konven').prop('checked', true);
//        } else if (data.ktrjns == 'Syariah') {
//            $('#syariah').prop('checked', true);
//        }
//        $('#modalProject').modal('show');
    });
}

function saveDataProject() {
    let form = $('#formUpsertProject');
    let url = 'http://localhost:8080/project/project/upsert';
    let method = form.attr('method');
    let data = form.serialize();

    console.log(data);

    $.ajax({
        url: url,
        type: method,
        data: data,
        success: function (response) {
            // resetValidation();
            resetValues();
            $('#modalProject').modal('hide');
            reloadTable();
        },
        error: function (response) {
            let errors = response;
            console.log(errors);
            // resetValidation();
            /*
            $.each(errors, function (key, value) {
                $(`#${key}`).addClass('is-invalid');
                $(`#${key}`).closest('.form-group').append(`<div class="invalid-feedback">${value}</div>`);
            });
            */
        }
    });
}

function loginUser() {
    let form = $('#formLoginNoSso');
    let url = 'http://localhost:8080/user/user/upsert';
    let method = form.attr('method');
    let data = form.serialize();

    console.log(data);

    $.ajax({
        url: url,
        type: method,
        data: data,
        success: function (response) {
            // resetValidation();
            resetValues();
            $('#modalKantor').modal('hide');
            reloadTable();
        },
        error: function (response) {
            let errors = response;
            console.log(errors);
            // resetValidation();
            /*
            $.each(errors, function (key, value) {
                $(`#${key}`).addClass('is-invalid');
                $(`#${key}`).closest('.form-group').append(`<div class="invalid-feedback">${value}</div>`);
            });
            */
        }
    });
}

function resetValues() {
    $('#projectId').val('');
    $('#namaProject').val('');
    $('#namaDepartemen').val('');
    $('#projectOwner').val('');
    $('#projectManager').val('');
    $('#namaKantor').val('');
    $('#priority').val('');
    $('#bobot').val('');
    $('#tglMulai').val('');
    $('#tglSelesai').val('');
    $('#description').val('');
    $('#status').val('');
//    $('#konven').prop('checked', false);
//    $('#syariah').prop('checked', false);
}

function reloadTable() {
    /*
    var domain = window.location.href;
    $('#tableKantor').load(domain + ' #tableKantor');
    */
    // reload the page
    window.location.reload();
    // load the head HTML and kantor table
    // $('#tableKantor').load(document.URL + ' #tableKantor');
}
