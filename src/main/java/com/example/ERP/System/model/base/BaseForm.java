package com.example.ERP.System.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseForm<T extends Enum<T>> implements Serializable {

    protected List<String> validationErrors = new ArrayList<>();


}
