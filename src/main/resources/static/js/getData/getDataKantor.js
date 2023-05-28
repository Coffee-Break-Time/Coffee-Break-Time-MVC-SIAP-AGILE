(function () {

    // get all element with id buttonEdit
    let btnEdit = document.querySelectorAll('#buttonEdit');
    // loop all element buttonEdit
    btnEdit.forEach(function (element) {
        // add event click
        element.addEventListener('click', function () {
            // get value attribute id
            let id = this.getAttribute('data-id');
            console.log(id);
            // call function getDataKantor
            getDataKantor(id);
        });
    });

    let btnClose = document.querySelector('#btnClose');
    btnClose.addEventListener('click', function () {
        resetValues();
    });

    // get element buttonSave
    let btnSave = document.querySelector('#btnSave');
    // add event click
    btnSave.addEventListener('click', function (e) {
        // e.preventDefault();
        // call function saveDataKantor
        saveDataKantor();
    });

    let modalKantor = document.querySelector('#modalKantor');
    //jika modalKantor hidden maka akan direset value
    modalKantor.addEventListener('hidden.bs.modal', function () {
        resetValues();
    });


})();

//ajax get data Cabang from controller kantor/{id}
// dimana data cabang akan diterima sebagai th:object di form edit kantor

function getDataKantor(id) {

//     get data cabang
    $.get(`http://localhost:8080/organisasi/kantor/${id}`).then(function (data) {
        console.log(data);
        $('#cabangId').val(data.cabangId);
        $('#namaCabang').val(data.namaCabang);
        $('#nomorTelpCabang').val(data.nomorTelpCabang);
        $('#alamat').val(data.alamat);
        if (data.jenisKantor == 'Konven') {
            $('#konven').prop('checked', true);
        } else if (data.jenisKantor == 'Syariah') {
            $('#syariah').prop('checked', true);
        }
        $('#modalKantor').modal('show');
    });

}

function saveDataKantor() {
    let form = $('#formUpsertKantor');
    let url = 'http://localhost:8080/organisasi/kantor/upsert'
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
            /*$.each(errors, function (key, value) {
                $(`#${key}`).addClass('is-invalid');
                $(`#${key}`).closest('.form-group').append(`<div class="invalid-feedback">${value}</div>`);
            });*/
        }
    });
}

function resetValues() {
    $('#cabangId').val('');
    $('#namaCabang').val('');
    $('#nomorTelpCabang').val('');
    $('#alamat').val('');
    $('#konven').prop('checked', false);
    $('#syariah').prop('checked', false);
}

function reloadTable() {
    /*var domain = window.location.href;
    $('#tableKantor').load(domain + ' #tableKantor');*/
    //reload page
    window.location.reload();
    //load head html and table kantor
    // $('#tableKantor').load(document.URL + ' #tableKantor');
}



