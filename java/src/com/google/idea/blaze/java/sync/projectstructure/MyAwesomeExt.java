package com.google.idea.blaze.java.sync.projectstructure;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.TestSourcesFilter;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class MyAwesomeExt extends TestSourcesFilter {
	@Override
	public boolean isTestSource(@NotNull VirtualFile file, @NotNull Project project) {
//		ProjectFileIndex.SERVICE.getInstance(project).get
//		project.
		return true;
	}
}
