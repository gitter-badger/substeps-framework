package com.technophobia.substeps.runner.description;

import com.technophobia.substeps.execution.node.IExecutionNode;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;

public class JunitLegacyDescriptionBuilder extends AbstractReflectiveDescriptionBuilder {

    @Override
    protected Class<?>[] constructorParameterTypes() {
        return new Class<?>[]{String.class, Array.newInstance(Annotation.class, 0).getClass()};
    }

    @Override
    protected Object[] constructorArguments(IExecutionNode node, DescriptorStatus status) {
        return new Object[]{getDescriptionForNode(node, status), new Annotation[0]};
    }
}
