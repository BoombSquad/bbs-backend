async function registerUser(){
    if($("#txtPass").val() == $("#txtPass2").val()){
        const form = {
            "email": $("#txtEmail").val(),
            "name": $("#txtName").val(),
            "password": $("#txtPass").val(),
            "surname": $("#txtSurname").val(),
            "phone": $("#txtPhone").val(),
            "address": $("#txtAddress").val(),
            "documentNumber": $("#txtDocumentNumber").val()
        }
        fetch("http://192.168.33.11:8079/user/create", {
            method: "POST", 
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(form)
          }).then(res => {
            console.log("Request complete! response:", res);
          });
    }else {
        console.log("VOCE ERROU FILHO DA PUTA")
    }
}

async function getUser(){
    console.log(document.register.elements[2]);
    const user_id = "ae5b817e-e839-428b-93b2-e47d4bb97fb6";
    const response = await fetch(`http://localhost:8080/snkr/${user_id}`);
    const data = await response.json();
    console.log(data);
    console.log(data.content[0].price)
}
