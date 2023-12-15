<?php
require_once "models/userModel.php";

class UsersController { 
    private $model;

    public function __construct(){
        $this->model = new UserModel();
    }

    public function crear (array $arrayUser):void {
        $id=$this->model->insert ($arrayUser);
        ($id==null)?header("location:index.php?tabla=user&accion=crear&error=true&id={$id}"): header("location:index.php?tabla=user&accion=ver&id=".$id);
        exit ();
    }
    public function ver(int $id): ?stdClass
    {
        return $this->model->read($id);
    }
    public function listar (){
        return $this->model->readAll ();
   }
   public function borrar(int $id): void
{
    $borrado = $this->model->delete($id);//hace un read antes de borrar el usuario y coge el nombre
    $redireccion = "location:index.php?accion=listar&tabla=user&evento=borrar&id={$id}&nombre={$user->name}&usuario={$user->usuario}";
    
    if ($borrado == false) $redireccion .=  "&error=true";
    header($redireccion);
    exit();
}
public function editar (int $id, array $arrayUser):void {
    $editadoCorrectamente=$this->model->edit ($id, $arrayUser);
    //lo separo para que se lea mejor en el word
    $redireccion="location:index.php?tabla=user&accion=editar";
    $redireccion.="&evento=modificar&id={$id}";
    $redireccion.=($editadoCorrectamente==false)?"&error=true":"";
    //vuelvo a la pagina donde estaba
    header ($redireccion);
    exit();
    }
    public function buscar (string $usuario):array {
        return $this->model->search ($usuario);
     }

}