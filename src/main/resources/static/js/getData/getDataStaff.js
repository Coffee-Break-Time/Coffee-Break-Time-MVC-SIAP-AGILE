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
        e.preventDefault();
        let id = this.getAttribute('data-id');

        console.log(id);
        // call function saveDataKantor
        saveDataKantor();
    });


    // get all element with id buttonDelete
    let btnDelete = document.querySelectorAll('#buttonDelete');
    // loop all element buttonDelete
    btnDelete.forEach(function (element) {
        // add event click
        element.addEventListener('click', function () {
            // get value attribute id
            let id = this.getAttribute('data-id');
            console.log(id);
            // call function deleteKantor
            deleteStaff(id);
        });
    }
    //create ajax


    );


   //create modal success delete






})();

//ajax get data Cabang from controller kantor/{id}
// dimana data cabang akan diterima sebagai th:object di form edit kantor



function getDataKantor(namaStaff) {

//     get data cabang
    $.get(`http://localhost:8080/organisasi/staff/${namaStaff}`).then(function (data) {
        console.log(data);
        $('#namaStaff').val(data.namaStaff);
        $('#email1').val(data.email1);
        $('#namaDepartemenStaff').val(data.namaDepartemenStaff);
        $('#nomorTlp1').val(data.nomorTlp1);
        $('#nomorTlp2').val(data.nomorTlp2);

        $('#modalStaff').modal('show');
    });

}

function saveDataKantor() {
    let form = $('#formUpsertStaff');
    let url = 'http://localhost:8080/organisasi/staff/upsert'
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
            $('#modalStaff').modal('hide');
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
    $('#namaStaff').val('');
    $('#email1').val('');
    $('#namaDepartemenStaff').val('');
    $('#nomorTlp1').val('');
    $('#nomorTlp2').val('');


}

function reloadTable() {
    /*var domain = window.location.href;
    $('#tableKantor').load(domain + ' #tableKantor');*/
    //reload page
    window.location.reload();
}


//create method delete staff and call ajax delete

function deleteStaff(id) {
    console.log(id);
    let url = `http://localhost:8080/organisasi/staff/delete/${namaStaff}`;
    let token = $("meta[name='_csrf']").attr("content");
    let header = $("meta[name='_csrf_header']").attr("content");

    console.log(url);

    $.ajax({
        url: url,
        type: 'DELETE',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (response) {
            console.log(response);
            reloadTable();
        },
        error: function (response) {
            console.log(response);
        }
    });


}




