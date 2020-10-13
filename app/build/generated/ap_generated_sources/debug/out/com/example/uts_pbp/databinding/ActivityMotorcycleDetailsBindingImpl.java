package com.example.uts_pbp.databinding;
import com.example.uts_pbp.R;
import com.example.uts_pbp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMotorcycleDetailsBindingImpl extends ActivityMotorcycleDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMotorcycleDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityMotorcycleDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[0]
            , (android.widget.TextView) bindings[6]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[5]
            );
        this.MotorAdapter.setTag(null);
        this.tvHarga.setTag(null);
        this.tvImage.setTag(null);
        this.tvJenis.setTag(null);
        this.tvKondisi.setTag(null);
        this.tvMerk.setTag(null);
        this.tvTahun.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.mtr == variableId) {
            setMtr((com.example.uts_pbp.Motor) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMtr(@Nullable com.example.uts_pbp.Motor Mtr) {
        this.mMtr = Mtr;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.mtr);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.uts_pbp.Motor mtr = mMtr;
        java.lang.String mtrJenis = null;
        java.lang.String mtrTahun = null;
        java.lang.String mtrKondisi = null;
        java.lang.String mtrFoto = null;
        java.lang.String mtrMerk = null;
        java.lang.String mtrHarga = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (mtr != null) {
                    // read mtr.jenis
                    mtrJenis = mtr.getJenis();
                    // read mtr.tahun
                    mtrTahun = mtr.getTahun();
                    // read mtr.kondisi
                    mtrKondisi = mtr.getKondisi();
                    // read mtr.foto
                    mtrFoto = mtr.getFoto();
                    // read mtr.merk
                    mtrMerk = mtr.getMerk();
                    // read mtr.harga
                    mtrHarga = mtr.getHarga();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvHarga, mtrHarga);
            com.example.uts_pbp.Motor.loadImage(this.tvImage, mtrFoto);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvJenis, mtrJenis);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvKondisi, mtrKondisi);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvMerk, mtrMerk);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTahun, mtrTahun);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): mtr
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}