(function () {

    // get all elements with id buttonEdit
    let btnEdit = document.querySelectorAll('#buttonEdit');
    // loop through all buttonEdit elements
    btnEdit.forEach(function (element) {
        // add click event
        element.addEventListener('click', function () {
            // get value of data-id attribute
            let id = this.getAttribute('data-id');
            console.log(id);
            // call getDataKantor function
            getDataKantor(id);
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
        saveDataKantor();
    });

    let btnLogin = document.querySelector('#btnLogin');
    // add click event
    btnLogin.addEventListener('click', function (e) {
        // e.preventDefault();
        // call loginUser function
        loginUser();
    });

    let modalKantor = document.querySelector('#modalKantor');
    // if modalKantor is hidden, reset the values
    modalKantor.addEventListener('hidden.bs.modal', function () {
        resetValues();
    });

})();

// ajax get data Cabang from controller kantor/{id}
// where data cabang will be received as th:object in the edit kantor form

function getDataKantor(id) {
    // get cabang data
    $.get(`http://localhost:8080/kantor/kantor/${id}`).then(function (data) {
        console.log(data);
        $('#id').val(data.id);
        /*
        if (data.id != null) {
            var headingElement = document.getElementById('kantorTitle');
            headingElement.textContent = 'Edit Kantor';
            console.log(data.id);
        }
        */
        $('#ktrname').val(data.ktrname);
        $('#ktrnohp').val(data.ktrnohp);
        $('#ktradds').val(data.ktradds);
        if (data.ktrjns == 'Konven') {
            $('#konven').prop('checked', true);
        } else if (data.ktrjns == 'Syariah') {
            $('#syariah').prop('checked', true);
        }
        $('#modalKantor').modal('show');
    });
}

function saveDataKantor() {
    let form = $('#formUpsertKantor');
    let url = 'http://localhost:8080/kantor/kantor/upsert';
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
    $('#id').val('');
    $('#ktrname').val('');
    $('#ktrnohp').val('');
    $('#ktradds').val('');
    $('#konven').prop('checked', false);
    $('#syariah').prop('checked', false);
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
