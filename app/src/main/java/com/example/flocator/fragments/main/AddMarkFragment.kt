package com.example.flocator.fragments.main

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.flocator.R
import com.example.flocator.adapters.CarouselViewPagerAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton

class AddMarkFragment : BottomSheetDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)

        dialog.setContentView(R.layout.fragment_add_mark)

        val viewPager = dialog.findViewById(R.id.photo_carousel) as ViewPager2
        viewPager.adapter = CarouselViewPagerAdapter()

        val addMarkButton = dialog.findViewById(R.id.add_mark_btn) as MaterialButton
        val cancelMarkButton = dialog.findViewById(R.id.cancel_mark_btn) as MaterialButton

        addMarkButton.setOnClickListener {
            dismiss()
        }

        cancelMarkButton.setOnClickListener {
            dismiss()
        }

        dialog.setOnShowListener {
            (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        dialog.setOnDismissListener {
            (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragment = inflater.inflate(R.layout.fragment_add_mark, container, false)

        return fragment
    }



    companion object {
        const val TAG = "ModalBottomSheet"
    }
}