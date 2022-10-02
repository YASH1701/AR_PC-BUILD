package com.godkiller.reoract;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class ArPage extends AppCompatActivity implements View.OnClickListener {

    private ArFragment arFragment;
    private ModelRenderable SSDRenderable,FANRenderable,RAMRenderable,ProcessorRenderable,HDDRenderable,CASERenderable,SMPSRenderable,MOTHERRenderable,GPURenderable;
    ImageView cpu,ssd,ram,fan,gpu,casea,smps,hdd,motherboard;
    View arrayview[];

    int selected = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_page);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arfragment);

        cpu = findViewById(R.id.cpu);
        ssd = findViewById(R.id.ssd);
        ram = findViewById(R.id.ram);
        fan = findViewById(R.id.fan);
        gpu = findViewById(R.id.gpua);
        casea = findViewById(R.id.casea);
        smps = findViewById(R.id.smps);
        hdd = findViewById(R.id.hdd);
        motherboard = findViewById(R.id.motherboard);

        setArrayView();
        setClickListener();
        setupModel();

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                arFragment.getArSceneView().getScene().addChild(anchorNode);

                createModel(anchorNode,selected);
        });
    }

    private void setupModel() {

        ModelRenderable
                    .builder()
                    .setSource(this,R.raw.i7)
                    .build()
                    .thenAccept(renderable -> ProcessorRenderable = renderable)
                    .exceptionally(
                            throwable -> {
                                Log.i("TAG", "Unable to load Renderable.", throwable);
                                return null;
                            });

        ModelRenderable
                .builder()
                .setSource(this,R.raw.m2samsungevo970)
                .build()
                .thenAccept(renderable -> SSDRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Log.i("TAG", "Unable to load Renderable.", throwable);
                            return null;
                        });


        ModelRenderable
                .builder()
                .setSource(this,R.raw.corsairfan)
                .build()
                .thenAccept(renderable -> FANRenderable= renderable)
                .exceptionally(
                        throwable -> {
                            Log.i("TAG", "Unable to load Renderable.", throwable);
                            return null;
                        });


        ModelRenderable
                .builder()
                .setSource(this,R.raw.gskilltridentz)
                .build()
                .thenAccept(renderable -> RAMRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Log.i("TAG", "Unable to load Renderable.", throwable);
                            return null;
                        });

        ModelRenderable
                .builder()
                .setSource(this,R.raw.corsair_200r)
                .build()
                .thenAccept(renderable -> CASERenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Log.i("TAG", "Unable to load Renderable.", throwable);
                            return null;
                        });

        ModelRenderable
                .builder()
                .setSource(this,R.raw.smps)
                .build()
                .thenAccept(renderable -> SMPSRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Log.i("TAG", "Unable to load Renderable.", throwable);
                            return null;
                        });

        ModelRenderable
                .builder()
                .setSource(this,R.raw.gpu)
                .build()
                .thenAccept(renderable -> GPURenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Log.i("TAG", "Unable to load Renderable.", throwable);
                            return null;
                        });
        ModelRenderable
                .builder()
                .setSource(this,R.raw.hdd)
                .build()
                .thenAccept(renderable -> HDDRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Log.i("TAG", "Unable to load Renderable.", throwable);
                            return null;
                        });

        ModelRenderable
                .builder()
                .setSource(this,R.raw.mother)
                .build()
                .thenAccept(renderable -> MOTHERRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Log.i("TAG", "Unable to load Renderable.", throwable);
                            return null;
                        });

    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if(selected == 1) {
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.getScaleController().setMaxScale(0.10f);
            transformableNode.getScaleController().setMinScale(0.02f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(ProcessorRenderable);
            transformableNode.select();
        }
        if(selected == 2) {
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.getScaleController().setMaxScale(0.10f);
            transformableNode.getScaleController().setMinScale(0.02f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(SSDRenderable);
            transformableNode.select();
        }
        if(selected == 3) {
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.getScaleController().setMaxScale(2.30f);
            transformableNode.getScaleController().setMinScale(0.90f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(RAMRenderable);
            transformableNode.select();
        }
        if(selected == 4) {
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.getScaleController().setMaxScale(2.30f);
            transformableNode.getScaleController().setMinScale(0.90f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(FANRenderable);
            transformableNode.select();
        }
        if(selected == 7) {
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.getScaleController().setMaxScale(2.30f);
            transformableNode.getScaleController().setMinScale(0.90f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(CASERenderable);
            transformableNode.select();
        }
        if(selected == 9) {
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.getScaleController().setMaxScale(2.30f);
            transformableNode.getScaleController().setMinScale(0.90f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(SMPSRenderable);
            transformableNode.select();
        }
        if(selected == 6) {
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.getScaleController().setMaxScale(2.30f);
            transformableNode.getScaleController().setMinScale(0.90f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(GPURenderable);
            transformableNode.select();
        }
        if(selected == 8) {
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.getScaleController().setMaxScale(2.30f);
            transformableNode.getScaleController().setMinScale(0.90f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(HDDRenderable);
            transformableNode.select();
        }
        if(selected == 5) {
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.getScaleController().setMaxScale(2.30f);
            transformableNode.getScaleController().setMinScale(0.90f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(MOTHERRenderable);
            transformableNode.select();
        }

    }

    private void setClickListener()
    {
        for(int i = 0; i < arrayview.length; i++ )
            arrayview[i].setOnClickListener(this);
    }

    private void setArrayView()
    {
        arrayview = new View[]{cpu,ssd,ram,fan,casea,motherboard,hdd,smps,gpu};
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.cpu)
        {
            selected = 1;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.ssd)
        {
            selected = 2;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.ram)
        {
            selected = 3;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.fan)
        {
            selected = 4;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.motherboard)
        {
            selected = 5;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.gpua)
        {
            selected = 6;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.casea)
        {
            selected = 7;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.hdd)
        {
            selected = 8;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.smps)
        {
            selected = 9;
            setBackground(v.getId());
        }
    }

    private void setBackground(int id) {
        for (int i = 0; i < arrayview.length; i++)
        {
            if (arrayview[i].getId() == id)
            {
                arrayview[i].setBackgroundColor(Color.parseColor("#80333639"));
            }
            else
            {
                arrayview[i].setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }
}
