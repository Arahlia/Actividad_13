<?php
require_once "models/clientModel.php";

class ClientsController{
    private $model;
    public function __construct(){
        $this->model =new ClientModel();
    }

    public function crear(array $arrayCLients):void{
        $id=$this->model->insert ($arrayClients);
        ($id==null)?header("location:index.php?tabla=client&accion=crear&evento=borrar&id={$id}");
        exit();
    }
    public function ver(){
        
    }
}