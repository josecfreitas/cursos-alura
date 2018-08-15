<?php

require_once "global.php";

class MessageException
{

    public $e;

    public function __construct($e)
    {
        $this->e = $e;
        
        if (DEBUG) {
            echo "<pre>";
            print_r($e);
            echo "</pre>";
        } else {
            echo ($e->getMessage());
        }

        exit;
    }
}
