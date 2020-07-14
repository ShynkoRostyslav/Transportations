
const form=document.getElementById('form');
const  username =document.getElementById('username_1');
const  age =document.getElementById('age_1');
const  surname =document.getElementById('surname_1');
const password = document.getElementById('password_1');
var error_1=false;
var error_2 = false;
var error_3= false;
var error_4 = false;


console.log(username);
form.addEventListener('submit', (e)=>{
   if(error_1=== true && error_2=== true && error_3=== true && error_4===true){
e.preventDefault();
   }
checkinputs();



})

 function checkinputs(){
const usernameValue = username.value.trim();
const ageValue = age.value.trim();
const surnameValue = surname.value.trim();
const passwordValue =password.value.trim();
    if(usernameValue===''){

    setError_1('Username is empty');



     }else{

      
  succes_1();


     }

if(Number(ageValue)<18){
setError_2('Yout  are a child');


 }else{
      succes_2();


 }

 if(surnameValue===''){
  setError_3('Surname is empty');

 }else{
succes_3();

 }

if(passwordValue===''){
  setError_4('Password is empty');
}else{
  succes_4();

}

}
 function setError_1(message){
   error_1=true;
const small = document.getElementById("userError_1");

small.innerText= message;
small.className='userError';

username.className='sven m';
const u_ii=document.getElementById('u_2');
u_ii.className = '';
const u_i=document.getElementById('u_1');
u_i.className = 'fas fa-exclamation-circle';


 }

 function setError_2(message){
   error_2=false;

const small = document.getElementById('ageError_1');
small.className='ageError'
small.innerText=message;
age.className='sven m';

const a_1 =  document.getElementById('a_1');
a_1.className= 'fas fa-exclamation-circle'; 
const u_ii=document.getElementById('a_2');
u_ii.className = '';


 }
 function setError_3(message){
   error_3=false;
  const small = document.getElementById('surnameError_1');
  small.innerText=message;
  small.className='surnameError';
  surname.className='sven m';
  const s_1 =  document.getElementById('s_1');
  const u_ii=document.getElementById('s_2');
  u_ii.className = '';
  s_1.className= 'fas fa-exclamation-circle'; 
  

   }
   function setError_4(message){
     error_4=false;
    const small = document.getElementById('passwordError_1');
    small.innerText=message;
    small.className='passwordError';
    password.className='sven m';
    const p_1 =  document.getElementById('p_1');
    p_1.className= 'fas fa-exclamation-circle'; 
    const u_ii=document.getElementById('p_2');
u_ii.className = '';
    
  
     }

function succes_1(){
  
error_1= true;

  const small = document.getElementById("userError_1");
  small.className='';
 username.className= 'slark';


 const u_i=document.getElementById('u_1');
 u_i.className = '';


const u_ii=document.getElementById('u_2');
u_i.className = 'fas fa-check-circle';



}


function succes_2(){
  error_2= true;
  const small = document.getElementById("ageError_1");
  small.className='';
 age.className= 'slark';



 const u_i=document.getElementById('a_1');
 u_i.className = '';


const u_ii=document.getElementById('a_2');
u_ii.className = 'fas fa-check-circle';

}



function succes_3(){
  error_4= true;
  const small = document.getElementById("surnameError_1");
  small.className='';
 surname.className= 'slark';



 const u_i=document.getElementById('s_1');
 u_i.className = '';


const u_ii=document.getElementById('s_2');
u_ii.className = 'fas fa-check-circle';

}


function succes_4(){
  error_4= true;
  const small = document.getElementById("passwordError_1");
  small.className='';
 password.className= 'slark';



 const u_i=document.getElementById('p_1');
 u_i.className = '';


const u_ii=document.getElementById('p_2');
u_ii.className = 'fas fa-check-circle';


}

 
